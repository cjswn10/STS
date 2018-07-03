package com.bit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.DeptManager;
import com.bit.vo.DeptVO;

@Repository
public class DeptDAO {
	public List<DeptVO> listAll() {
		return DeptManager.listAll();
	}
}
