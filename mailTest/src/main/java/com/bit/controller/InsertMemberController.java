package com.bit.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDao;
import com.bit.vo.MemberVo;


@Controller
@RequestMapping("/insertMember.do")
public class InsertMemberController {

	
	@Autowired
	private MemberDao dao;
		
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public void form()
	{	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(MemberVo m)
	{
		
		ModelAndView mav = new ModelAndView("insertMemberOk");
		
		int re = dao.insert(m);
		String msg = "ȸ�����Կ� �����Ͽ����ϴ�.";
		if(re < 1)
		{
			msg = "ȸ�����Կ� �����Ͽ����ϴ�.";
		}
		
		mav.addObject("msg", msg);
		
		return mav;
	}
}









