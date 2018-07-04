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
		String msg = "������ü ����";

		Map map = new HashMap();
		map.put("from", from);
		map.put("to", to);
		map.put("amount", amount);
		
		int r = dao.transfer(map);
		if(r == -1) {
			msg = "�ܾ� ����";
		} else if(r == -2) {
			msg = "�ݾ��� 0�� �̻��̾�� �մϴ�.";
		} else if(r == -3) {
			msg = "���������� ���°� �������� �ʽ��ϴ�.";
		} else if(r == -4) {
			msg = "�޴����� ���°� �������� �ʽ��ϴ�.";
		}
		mv.addObject("msg", msg);
		
		return mv;
	}
}
