package com.trouble.catering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trouble.catering.pojo.Goods;
import com.trouble.catering.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/showAll")
	@ResponseBody
	public List<Goods> showAll(){
		return goodsService.findAll();
	}
	

}
