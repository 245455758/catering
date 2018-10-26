package com.trouble.catering.service;

import java.util.List;

import com.trouble.catering.pojo.Shop;

public interface ShopService {
	
	public List<Shop> findAll();
	
	public int validateShop(int id);
	
	public int deleteShop(int id);

	public List<Shop> findAllCheckedShop();
	
	

}
