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
		String str = "ȸ�� ���ԿϷ�";
		if(re < 0) {
			str = "ȸ�� ���� ����";
		}
		mv.addObject("msg", str);
		return mv;
	}
	
	@RequestMapping(value="/authEmail.do")
	public String authEmail(int aNum, String email) {
		System.out.println(aNum+"�̶�"+email);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setSubject("������ȣ");
		mail.setFrom("chewon10@naver.com");
		mail.setText("["+aNum+"]������ȣ�� ȭ�鿡 �Է��ϼ���");
		mail.setTo(email);
		
		String str = "����";
		try {
			mailSender.send(mail);
			str += "�Ϸ�";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
}
