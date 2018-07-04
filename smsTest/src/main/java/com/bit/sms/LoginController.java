package com.bit.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;

@Controller
@RequestMapping("/login.do")
public class LoginController {
	@Autowired
	private MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(String id, String pwd) {
	
		ModelAndView mv = new ModelAndView("main");
		
		MemberVO m = dao.getMember(id, pwd);
		if(m == null) {
			mv.setViewName("redirect:/login.do");
			mv.addObject("msg", "다시입력하세요");
		}
		mv.addObject("m", m);
		return mv;
	}
	
}
