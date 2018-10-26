package com.trouble.catering.service;

import java.util.List;

import com.trouble.catering.pojo.Goods;

public interface GoodsService {
	
	public List<Goods> findAll();
	
	public int updateGoods(Goods goods);

}
