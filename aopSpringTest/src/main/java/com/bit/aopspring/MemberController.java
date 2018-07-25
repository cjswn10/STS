package com.bit.aopspring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@RequestMapping("/insertMember.do")
	public void insert(HttpServletRequest request) {
		
	}
	
	@RequestMapping("/listMember.do")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView list = new ModelAndView();
		return list;
	}
}
