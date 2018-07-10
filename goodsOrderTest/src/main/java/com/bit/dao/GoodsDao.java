package com.bit.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.GoodsManager;
import com.bit.vo.GoodsVo;

@Repository
public class GoodsDao {
	public List<GoodsVo> listAll() {
		return GoodsManager.listAll();
	}
	
	public static GoodsVo getGoods(Map map) {
		return GoodsManager.getGoods(map);
	}
}
