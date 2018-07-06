package com.bit.gss;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	Map map = new HashMap();
	
	@RequestMapping("/listGoods.do")
	public ModelAndView list(String keyField, String keyword, String sort, HttpSession session) {
		
		/*
		//검색어가 오지 않고 세션에 값이 실려 있다면
		if(keyword == null && session.getAttribute("keyword") != null) {
			keyword =(String)session.getAttribute("keyword");
		}
		map.put("keyword", keyword);
		*/
		

		if(keyword != null) {
			map.put("keyField", keyField);
			map.put("keyword", keyword);
		}
			
		map.put("sort", sort);
		System.out.println(keyField);
		System.out.println("key:" + keyword + map.get("keyword"));
		System.out.println("sort:"+ sort);
		
		
		ModelAndView mv = new ModelAndView("/listGoods");
		mv.addObject("list", dao.listAll(map));
		//session.setAttribute("keyword", keyword);
		
		
		return mv;
	}
	
}
