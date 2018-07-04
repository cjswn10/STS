package com.bit.schedule;

import java.util.List;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.bit.dao.MemberDao;
import com.bit.vo.MemberVo;

@Controller
public class emailScheduleController {
	private MemberDao dao;
	private MailSender mailSender;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Scheduled(cron="0 56 12 * * ?")
	public void sendMail() {
		List<MemberVo> list = dao.listAll();
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setSubject("정기메일");
		mail.setFrom("chewon10@naver.com");
		for(MemberVo m : list) {
			mail.setText(m.getName() + "님 바보~");
			mail.setTo(m.getEmail());
			System.out.println(m.getEmail());
			
			try {
				mailSender.send(mail);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
