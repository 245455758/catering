package com.trouble.catering.service;

import java.util.List;

import com.trouble.catering.pojo.User;
import com.trouble.catering.pojo.UserDetail;

public interface ShopperService {
	
	public List<User> findAllShoppers();
	
	public List<User> findAllUnChecked();

	public UserDetail findUserDetail(int id);

}
