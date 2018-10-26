package com.trouble.catering.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trouble.catering.entity.Result;
import com.trouble.catering.entity.ShopperEntity;
import com.trouble.catering.mapper.UserMapper;
import com.trouble.catering.pojo.User;
import com.trouble.catering.pojo.UserDetail;
import com.trouble.catering.service.ShopperService;

@RestController
@RequestMapping("/shopper")
public class ShopperController {
	
	@Autowired
	private ShopperService shopperService;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 展示所有的商家
	 * @return
	 */
	@RequestMapping("/showAll")
	@ResponseBody
	public List<User> showAll() {
		return shopperService.findAllShoppers();
	}
	
	@RequestMapping("/showAllUnChecked")
	@ResponseBody
	public Map showAllUnCheckedShoppers(){
		List<User> shoppers = shopperService.findAllUnChecked();
		List<ShopperEntity> entity = new ArrayList<ShopperEntity>();
		for (User user : shoppers) {
			entity.add(new ShopperEntity(user.getId()+"", user.getUsername()));
		}
		Map map = new HashMap();
		map.put("shoppers", shoppers);
		map.put("entity", entity);
		
		return map;
	}
	/**
	 * 用户审核
	 * @param str
	 * @return
	 */
	@RequestMapping("/validateUser")
	@ResponseBody
	public Result ValidateUser(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		String[] ids = jsonStr.getString("id").replace("[", "").replace("]", "").replace("\"", "").split(",");
		try {
			for (String string : ids) {
				userMapper.validateUser(Integer.parseInt(string));
			}
			return new Result(true, "更新成功");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("/undoValidate")
	@ResponseBody
	public Result undoValidate(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		String[] ids = jsonStr.getString("id").replace("[", "").replace("]", "").replace("\"", "").split(",");
		try {
			for (String string : ids) {
				userMapper.undoValidateUser(Integer.parseInt(string));
			}
			return new Result(true, "更新成功");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}
	
	@RequestMapping("/showDetail")
	@ResponseBody
	public UserDetail showDetails(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		String[] ids = jsonStr.getString("id").replace("[", "").replace("]", "").replace("\"", "").split(",");
		
		return shopperService.findUserDetail(Integer.parseInt(ids[0]));
	}
	
	@RequestMapping("/deleteShoppers")
	@ResponseBody
	public Result deleteShoppers(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		String[] ids = jsonStr.getString("id").replace("[", "").replace("]", "").replace("\"", "").split(",");
		try {
			for (String string : ids) {
				userMapper.undoValidateUser(Integer.parseInt(string));
			}
			return new Result(true, "更新成功");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new Result(false, "更新失败");
		}
	}

}
