package com.bit.aopspring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController {

	@RequestMapping("/listGoods.do")
	public void list(HttpServletRequest request, String keyword) {
		System.out.println(4/0);
	}
}
