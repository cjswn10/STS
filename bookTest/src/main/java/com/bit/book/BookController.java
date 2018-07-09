package com.bit.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BookDAO;

@Controller
public class BookController {
	@Autowired
	private BookDAO dao;
	
	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	/*
	@RequestMapping(value="/listBook.do", method=RequestMethod.GET)
	public void listForm() {
		
	}
	*/

	@RequestMapping("/listBook.do")
	public ModelAndView listInfo(String name) {
		System.out.println(name);
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap();
		map.put("name", name);
		List list = dao.listInfo(map);
		mv.addObject("list", list);
		return mv;
	}
	
}
