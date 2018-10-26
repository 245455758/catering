package com.trouble.catering.service;

import java.util.List;

import com.trouble.catering.pojo.Resource;

public interface SourceService {
	/**
	 * 查找所有的资源id和name
	 * @return
	 */
	public List<Resource> findAllSIdAndName();

}
