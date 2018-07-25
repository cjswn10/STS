package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.NewsDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class NewsController {

	@Autowired
	private NewsDAO dao;

	public void setDao(NewsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/main.do")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping(value="/listNews.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String list() {
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(dao.listAll());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
