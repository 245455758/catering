package com.trouble.catering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trouble.catering.mapper.GoodsMapper;
import com.trouble.catering.pojo.Goods;
import com.trouble.catering.pojo.GoodsExample;
import com.trouble.catering.pojo.GoodsExample.Criteria;
import com.trouble.catering.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public List<Goods> findAll() {
		GoodsExample example = new GoodsExample();
		Criteria criteria = example.createCriteria();
		return goodsMapper.selectByExample(example );
	}

	@Override
	public int updateGoods(Goods goods) {
		return goodsMapper.updateByPrimaryKey(goods);
	}

}
