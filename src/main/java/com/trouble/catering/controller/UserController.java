package com.trouble.catering.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trouble.catering.pojo.User;
import com.trouble.catering.service.RoleService;
import com.trouble.catering.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("findUser")
	public User findUserById() {
		return userService.findUserById(1);
	}
	
	@RequestMapping("/submit")
	@ResponseBody
	public Map login(@RequestBody String name) {
		JSONObject jsonStr = JSON.parseObject(name);
		User user = userService.userLogin(jsonStr.getString("name"), jsonStr.getString("password"));
		System.out.println(user.getRole());
		if(user!=null) {
			Set rightsSet = roleService.getRights(user.getRole().intValue()+1);
			Map map = new HashMap();
			map.put("rights", rightsSet);
			map.put("res", true);
			return map;
		}else {
			Map map = new HashMap();
			map.put("res", false);
			return map;
		}
	}

}
