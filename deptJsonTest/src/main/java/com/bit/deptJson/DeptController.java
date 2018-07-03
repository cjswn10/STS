package com.bit.deptJson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.dao.DeptDAO;
import com.bit.vo.DeptVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DeptController {
	@Autowired
	private DeptDAO dao;
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/listDept.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String test() {
		List<DeptVO> list = dao.listAll();
		ObjectMapper mapper = new ObjectMapper();
		String str = "";
		try {
			str = mapper.writeValueAsString(list);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return str;
	}
}