package com.trouble.catering.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.trouble.catering.entity.Result;
import com.trouble.catering.pojo.Role;
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
	
	private Map rightsMap = new HashMap();
	/**
	 * 根据用户id查找用户
	 * @return
	 */
	@RequestMapping("findUser")
	public User findUserById() {
		return userService.findUserById(1);
	}
	/**
	 * 用户登录
	 * @param name
	 * @return
	 */
	@RequestMapping("/submit")
	@ResponseBody
	public Object login(@RequestBody String name) {
		JSONObject jsonStr = JSON.parseObject(name);
		User user = userService.userLogin(jsonStr.getString("name"), jsonStr.getString("password"));
		if(user!=null) {
			int indexOf = user.getRole().indexOf(",");
			if(indexOf<0) {
				Set rightsSet = roleService.getRights(Integer.parseInt(user.getRole()));
				Map map = new HashMap();
				map.put("res", true);
				map.put("rights", rightsSet);
				map.put("userId", user.getId());
				Object json = JSON.toJSON(map);
				return json;
			}else {
				String[] roles = user.getRole().split(",");
				Set rightsSet = new HashSet();
				for (String string : roles) {
					Set right = roleService.getRights(Integer.parseInt(string));
					for (Object object : right) {
						rightsSet.add(object);
					}
				}
				Map map = new HashMap();
				map.put("res", true);
				map.put("rights", rightsSet);
				map.put("userId", user.getId());
				Object json = JSON.toJSON(map);
				return json;
			}
		}else {
			Map map = new HashMap();
			map.put("res", false);
			Object json = JSON.toJSON(map);
			return json;
		}
	}
	
	/**
	 * 展示所有的用户
	 * @return
	 */
	@RequestMapping("/showAll")
	@ResponseBody
	public JSON showAll() {
		List<User> users = userService.findAll();
		List<Role> roles = roleService.findAllIdAndDesc();
		saveRights(roles);
		for (User user : users) {
			String[] roles1 = user.getRole().split(",");
			StringBuilder s = new StringBuilder();
			for (String str : roles1) {
				s.append(","+rightsMap.get(Integer.parseInt(str)));
			}
			user.setPassword(s.toString().substring(1));
		}
		Map map = new HashMap();
		map.put("users", users);
		map.put("roles", roles);
		System.out.println("showAll.map:"+map);
		return (JSON) JSON.toJSON(map);
	}
	
	private void saveRights(List<Role> roles) {
		System.out.println(roles);
		for (Role role : roles) {
			rightsMap.put(role.getId(), role.getDesc());
		}
	}
	/**
	 * 增加用户
	 * @param str
	 * @return
	 */
	@RequestMapping("addUser")
	@ResponseBody
	public Result add(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		String roles = jsonStr.getString("role").replace("[", "").replace("]", "");
		User user = new User(jsonStr.getString("username"),"111",
				jsonStr.getString("telephone"),
				roles,1);
		int res = userService.addUser(user);
		if(res>0) {
			return new Result(true, "添加成功");
		}else {
			return new Result(false, "添加失败");
		}
		
	}
	/**
	 * 根据传过来的数组id删除用户
	 * @param str
	 * @return
	 */
	@RequestMapping("/deleteUsers")
	@ResponseBody
	public Result deleteUsers(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		System.out.println(jsonStr.getString("idArr"));
		JSONArray jsonArray = jsonStr.getJSONArray("idArr");
		System.out.println(jsonArray);
		try {
			for (Object object : jsonArray) {
				userService.deleteUser((int)object);
			}
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	@RequestMapping("/updateUser.action")
	@ResponseBody
	public Result updateUser(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		User user = new User();
		String role = jsonStr.getString("role").replace("[", "").replace("]", "");
		System.out.println("user.role:"+role);
		user.setId(jsonStr.getInteger("id"));
		user.setUsername(jsonStr.getString("username"));
		user.setTelephone(jsonStr.getString("telephone"));
		user.setPassword(userService.findPasswordById(jsonStr.getInteger("id")));
		
		user.setRole(role);
		user.setIsvalidate(1);
		System.out.println("user:"+user);
		int res = userService.updateUser(user);
		if(res>0) {
			return new Result(true, "更新成功");
		}else {
			return new Result(false, "更新失败");
		}
	}

	
}
