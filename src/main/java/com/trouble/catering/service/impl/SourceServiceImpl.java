package com.trouble.catering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trouble.catering.mapper.ResourceMapper;
import com.trouble.catering.pojo.Resource;
import com.trouble.catering.service.SourceService;

@Service
public class SourceServiceImpl implements SourceService {
	
	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public List<Resource> findAllSIdAndName() {
		return resourceMapper.selectAllIdsAndName();
	}

}
