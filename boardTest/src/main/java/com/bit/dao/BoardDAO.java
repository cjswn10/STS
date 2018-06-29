package com.bit.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.bit.db.BoardManager;
import com.bit.vo.BoardVO;

@Repository
public class BoardDAO {
	
	public List<BoardVO> listAll() {
		return BoardManager.listAll();
	}
	
	public int insert(BoardVO b, HttpServletRequest request) {
		return BoardManager.insert(b, request);
	}
	
	public BoardVO detail(int no) {
		return BoardManager.detail(no);
	}
	
	public int update(BoardVO b) {
		return BoardManager.update(b);
	}
	
	public int delete(int no) {
		return BoardManager.delete(no);
	}
}
