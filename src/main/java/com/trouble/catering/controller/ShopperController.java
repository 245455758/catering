package com.trouble.catering.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trouble.catering.entity.ShopperEntity;
import com.trouble.catering.pojo.User;
import com.trouble.catering.service.ShopperService;

@RestController
@RequestMapping("/shopper")
public class ShopperController {
	
	@Autowired
	private ShopperService shopperService;
	
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

}
