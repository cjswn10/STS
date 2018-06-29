package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listMember.do")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("listMember");
		mv.addObject("list", dao.listAll());
		return mv;
	}
	
	@RequestMapping(value="/insertMember.do", method=RequestMethod.GET)
	public void insertForm() {
		
	}
	
	@RequestMapping(value="/insertMember.do", method=RequestMethod.POST)
	public ModelAndView insertSubmit(MemberVO m) {
		ModelAndView mv = new ModelAndView("redirect:listMember.do");
		int re = dao.insert(m);
		if(re < 0) {
			mv.addObject("msg", "추가 실패");
			mv.setViewName("error");
		}
		return mv;
	}
	
}
