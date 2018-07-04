package com.bit.account;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.AccountDAO;

@Controller
@RequestMapping("/transfer.do")
public class TransferController {

	@Autowired
	private AccountDAO dao;
	
	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(String from, String to, int amount) {
		ModelAndView mv = new ModelAndView("result");
		String msg = "계좌이체 성공";

		Map map = new HashMap();
		map.put("from", from);
		map.put("to", to);
		map.put("amount", amount);
		
		int r = dao.transfer(map);
		if(r == -1) {
			msg = "잔액 부족";
		} else if(r == -2) {
			msg = "금액은 0원 이상이어야 합니다.";
		} else if(r == -3) {
			msg = "보내는이의 계좌가 존재하지 않습니다.";
		} else if(r == -4) {
			msg = "받는이의 계좌가 존재하지 않습니다.";
		}
		mv.addObject("msg", msg);
		
		return mv;
	}
}
