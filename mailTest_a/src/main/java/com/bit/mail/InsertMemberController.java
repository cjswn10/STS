package com.bit.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;


@Controller
public class InsertMemberController {
	private MemberDAO dao;
	
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/insertMember.do", method=RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(value="/insertMember.do", method=RequestMethod.POST)
	public ModelAndView submit(MemberVO m) {
		ModelAndView mv = new ModelAndView("result");
		int re = dao.insert(m);
		String str = "회원 가입완료";
		if(re < 0) {
			str = "회원 가입 실패";
		}
		mv.addObject("msg", str);
		return mv;
	}
	
	@RequestMapping(value="/authEmail.do")
	public String authEmail(int aNum, String email) {
		System.out.println(aNum+"이랑"+email);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setSubject("인증번호");
		mail.setFrom("chewon10@naver.com");
		mail.setText("["+aNum+"]인증번호를 화면에 입력하세요");
		mail.setTo(email);
		
		try {
			mailSender.send(mail);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		String str = aNum + "";
		return str;
	}
}
