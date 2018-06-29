package com.bit.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listGoods.do")
	public ModelAndView listAll(String keyword, String keyField) {
		Map map = new HashMap();
		map.put("keyword", keyword);
		map.put("keyField", keyField);
		
		ModelAndView mv = new ModelAndView("listGoods");
		mv.addObject("list", dao.listAll(map));
		return mv;
	}
	
	@RequestMapping("/detailGoods.do")
	public ModelAndView detail(@RequestParam("no")int no) {
		ModelAndView mv = new ModelAndView("detailGoods");
		mv.addObject("g", dao.getGoods(no));
		return mv;
	}
	
	@RequestMapping("/deleteGoods.do")
	public ModelAndView delete(@RequestParam("no")int no, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		String path = request.getRealPath("resources/upload");
		String oldFname = dao.getGoods(no).getFname();
		System.out.println("삭제oldFname: " + oldFname);
		int re = dao.delete(no);
		String msg = "삭제 성공";
		
		if(re < 0) {
			//mv.addObject("msg", "삭제실패");
			//mv.setViewName("error");
			msg = "삭제 실패";
		} else {
			if(oldFname != null) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			mv.setViewName("redirect:listGoods.do");
		}
		HttpSession session = request.getSession();
		session.setAttribute("msg", msg);
		
		return mv;
	}
}
