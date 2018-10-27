package com.trouble.catering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trouble.catering.entity.Result;
import com.trouble.catering.mapper.ShopperDetailMapper;
import com.trouble.catering.pojo.Shop;
import com.trouble.catering.pojo.ShopperDetail;
import com.trouble.catering.service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ShopperDetailMapper shopperDetailMapper;
	
	@RequestMapping("/showAll")
	@ResponseBody
	public List<Shop> showAllUnchecked(){
		return  shopService.findAll();
	}
	@RequestMapping("/showAllCheckedShop")
	@ResponseBody
	public List<Shop> showAllChecked(){
		return  shopService.findAllCheckedShop();
	}
	
	@RequestMapping("/validateShop")
	@ResponseBody
	public Result validateShop(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		int res = shopService.validateShop( Integer.parseInt(jsonStr.getString("id")) );
		if(res>0) {
			return new Result(true,"更新成功");
		}else {
			return new Result(false,"更新失败");
		}
	}
	
	@RequestMapping("/deleteShop")
	@ResponseBody
	public Result deleteShop(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		int res = shopService.deleteShop(Integer.parseInt(jsonStr.getString("id")));
		if(res>0) {
			return new Result(true,"更新成功");
		}else {
			return new Result(false,"更新失败");
		}
	}
	
	@RequestMapping("/showDetail")
	@ResponseBody
	public ShopperDetail showDetail(@RequestBody String str) {
		JSONObject jsonStr = JSON.parseObject(str);
		Integer id = jsonStr.getInteger("id");
		
		int s_id = shopService.findShopIdByUserId(id).get(0).getId();
		
		return shopperDetailMapper.selectByPrimaryKey(s_id);
	}

}
