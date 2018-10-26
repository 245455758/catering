package com.trouble.catering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.trouble.catering.pojo.Resource;
import com.trouble.catering.service.SourceService;

@RestController
@RequestMapping("/source")
public class SourceController {
	
	@Autowired
	private SourceService sourceService;
	
	@RequestMapping("/showAll")
	@ResponseBody
	public List<Resource> showAll() {
		return sourceService.findAllSIdAndName();
	}

}
