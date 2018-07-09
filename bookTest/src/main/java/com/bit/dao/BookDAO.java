package com.bit.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.BookManager;
import com.bit.vo.InfoVO;

@Repository
public class BookDAO {
	public List<InfoVO> listInfo(Map map) {
		return BookManager.listInfo(map);
	}
}
