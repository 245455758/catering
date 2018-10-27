package com.trouble.catering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trouble.catering.mapper.ShopMapper;
import com.trouble.catering.pojo.Shop;
import com.trouble.catering.pojo.ShopExample;
import com.trouble.catering.pojo.ShopExample.Criteria;
import com.trouble.catering.service.ShopService;
@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopMapper shopMapper;
	
	@Override
	public List<Shop> findAll() {
		ShopExample example = new ShopExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(0);
		return shopMapper.selectByExample(example );
	}

	@Override
	public int validateShop(int id) {
		return shopMapper.updateInValidate(id);
	}

	@Override
	public int deleteShop(int id) {
		return shopMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shop> findAllCheckedShop() {
		ShopExample example = new ShopExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		return shopMapper.selectByExample(example );
	}

	@Override
	public List<Shop> findShopIdByUserId(int user_id) {
		ShopExample example = new ShopExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(user_id);
		return shopMapper.selectByExample(example );
	}

}
