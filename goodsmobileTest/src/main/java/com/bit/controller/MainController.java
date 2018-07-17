package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/main.do")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	@RequestMapping("/main2.do")
	public ModelAndView listGoods2() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping("/board.do")
	public ModelAndView boartList() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping("/board2.do")
	public ModelAndView boartList2() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
