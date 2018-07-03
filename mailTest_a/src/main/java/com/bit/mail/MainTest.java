package com.bit.mail;

import java.util.Random;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.vo.MemberVO;

@Controller
public class MainTest {
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/mail.do")
	public void mail() {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setSubject("안녕");
		mail.setFrom("chewon10@naver.com");
		mail.setText("좋은하루 보내세요~-연주");
		mail.setTo("cjswn10@gmail.com");
		
		try {
			mailSender.send(mail);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	@RequestMapping(value="/check.do")
	public ModelAndView check(String email) {
		ModelAndView m = new ModelAndView("checkView");
		//난수생성
		String random="";
		for(int i=0;i<4;i++) {
			random+=((new Random().nextInt(9)+1)+"");
		}
		
		//메일전송
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("회원가입절차) 이메일을 확인해주십시오.");
		mailMessage.setFrom("chewon10@naver.com");
		mailMessage.setText("입력할 번호는 ["+random+"] 입니다.");
		mailMessage.setTo(email);
		try {
			mailSender.send(mailMessage);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		m.addObject("email",email);
		m.addObject("random", random);
		return m;
	}
	
	@RequestMapping(value="insert.do",method=RequestMethod.GET)
	public ModelAndView insert(String email) {
		ModelAndView m = new ModelAndView("insertView");
		m.addObject("email",email);
		return m;
	}
	
	@RequestMapping(value="insert.do",method=RequestMethod.POST)
	public ModelAndView insertOk(MemberVO v) {
		ModelAndView m = new ModelAndView("insertView");
		return m;
	}
}
