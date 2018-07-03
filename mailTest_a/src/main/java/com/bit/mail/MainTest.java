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
		mail.setSubject("�ȳ�");
		mail.setFrom("chewon10@naver.com");
		mail.setText("�����Ϸ� ��������~-����");
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
		//��������
		String random="";
		for(int i=0;i<4;i++) {
			random+=((new Random().nextInt(9)+1)+"");
		}
		
		//��������
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("ȸ����������) �̸����� Ȯ�����ֽʽÿ�.");
		mailMessage.setFrom("chewon10@naver.com");
		mailMessage.setText("�Է��� ��ȣ�� ["+random+"] �Դϴ�.");
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
