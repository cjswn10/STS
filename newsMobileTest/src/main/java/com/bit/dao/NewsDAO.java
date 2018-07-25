package com.bit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.NewsManager;
import com.bit.vo.NewsVO;

@Repository
public class NewsDAO {
	public List<NewsVO> listAll() {
		return NewsManager.listAll();
	}
}
