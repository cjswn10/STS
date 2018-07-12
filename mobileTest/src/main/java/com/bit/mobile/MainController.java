package com.bit.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/main.do")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	@RequestMapping("/insert.do")
	public ModelAndView insert() {
		ModelAndView mv = new ModelAndView("main2");
		return mv;
	}

}
