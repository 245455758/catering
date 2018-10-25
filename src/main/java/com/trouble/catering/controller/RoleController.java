package com.trouble.catering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.trouble.catering.entity.Result;
import com.trouble.catering.pojo.Role;
import com.trouble.catering.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/showAll")
	@ResponseBody
	public JSON showAll() {
		List<Role> roles = roleService.findAll();
		return (JSON) JSON.toJSON(roles);
	}
	
	
	@RequestMapping("/updateRole.action")
	@ResponseBody
	public Result update(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		Role role = new Role();
		String right = jsonStr.getString("rights").replace("[", "").replace("]", "").replace("\"", "").replace(",", ";");
		role.setRights(right);
		role.setName(jsonStr.getString("name"));
		role.setDesc(jsonStr.getString("desc"));
		role.setId(jsonStr.getInteger("id"));
		System.out.println(role);
		int res = roleService.updateRole(role);
		if(res>0) {
			return new Result(true, "更新成功");
		}else {
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("/deleteRoles")
	@ResponseBody
	public Result deleteRoles(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		System.out.println(jsonStr.getString("idArr"));
		JSONArray jsonArray = jsonStr.getJSONArray("idArr");
		System.out.println(jsonArray);
		try {
			for (Object object : jsonArray) {
				roleService.deleteByKey((int)object);
			}
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	@RequestMapping("/addRole")
	@ResponseBody
	public Result addRole(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		Role role = new Role();
		String right = jsonStr.getString("rights").replace("[", "").replace("]", "").replace("\"", "").replace(",", ";");
		role.setRights(right);
		role.setName(jsonStr.getString("name"));
		role.setDesc(jsonStr.getString("desc"));
		System.out.println(role);
		int res = roleService.addRole(role);
		if(res>0) {
			return new Result(true, "保存成功");
		}else {
			return new Result(false, "保存失败");
		}
	}
	
}
