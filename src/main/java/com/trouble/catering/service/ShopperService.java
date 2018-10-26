package com.trouble.catering.service;

import java.util.List;

import com.trouble.catering.pojo.User;

public interface ShopperService {
	
	public List<User> findAllShoppers();
	
	public List<User> findAllUnChecked();

}
