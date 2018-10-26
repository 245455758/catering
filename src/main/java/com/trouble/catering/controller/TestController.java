package com.trouble.catering.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trouble.catering.entity.Result;
import com.trouble.catering.pojo.Goods;
import com.trouble.catering.service.GoodsService;
import com.trouble.catering.util.PhotoUtil;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "uploadPic",method = RequestMethod.POST)
    public Result upload(Model model,
     @RequestParam("myFile") MultipartFile file
    , HttpServletRequest request){
        //第一种返回页面的方法
        //model.addAttribute("img",PhotoUtil.saveFile(file,request));
       //第二种返回页面的方法
        String path = PhotoUtil.saveFile(file,request);
        
        List<Goods> goods = goodsService.findAll();
        try {
			for (Goods good : goods) {
				good.setPicPath(path);
				goodsService.updateGoods(good);
			}
			return new Result(true,"更新成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false,"更新失败");
		}
        
    }

}
