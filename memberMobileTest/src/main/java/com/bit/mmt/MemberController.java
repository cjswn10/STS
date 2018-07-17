package com.bit.mmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("/form.do")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping(value="/insert.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String submit(MemberVO m) {
		
		int re = dao.insert(m);
		String str = "추가 성공";
		if(re < 0)
			str = "추가 실패";
		
		return str;
	}
}
