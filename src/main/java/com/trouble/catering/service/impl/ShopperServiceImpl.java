package com.trouble.catering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trouble.catering.mapper.UserMapper;
import com.trouble.catering.pojo.User;
import com.trouble.catering.service.ShopperService;
@Service
public class ShopperServiceImpl implements ShopperService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAllShoppers() {
		return userMapper.selectAllShoppers();
	}

	@Override
	public List<User> findAllUnChecked() {
		return userMapper.selectAllUncheckedShoppers();
	}

}
