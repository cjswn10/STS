package com.bit.goodsJson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/insertGoods.do")
public class InsertGoodsController {
	
	
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
}
