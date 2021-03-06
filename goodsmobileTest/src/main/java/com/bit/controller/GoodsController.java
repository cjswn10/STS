package com.bit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.dao.GoodsDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/listGoods.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String listJson()
	{
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(dao.listAll());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}

}
