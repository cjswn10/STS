package com.bit.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.GoodsManager;
import com.bit.vo.GoodsVO;

@Repository
public class GoodsDAO {
	public List<GoodsVO> listAll() {
		return GoodsManager.listAll();
	}
	
	public int insert(GoodsVO g) {
		return GoodsManager.insert(g);
	}
}
