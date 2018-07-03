package com.bit.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDAO;

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
}
