package com.bit.goodsJson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping("/main.do")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "��Ʈ���� ���Ű��� ȯ���մϴ�.");
		
		return mv;
	}
}
