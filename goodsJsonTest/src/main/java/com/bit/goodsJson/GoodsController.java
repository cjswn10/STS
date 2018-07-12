package com.bit.goodsJson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;
import com.bit.vo.OrderInfo;
import com.bit.vo.GoodsVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GoodsController {

	@Autowired
	private GoodsDAO dao;
	
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/listGoods.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String listJson() {
		String str = "";
		List<GoodsVO> list = dao.listAll();
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			str = mapper.writeValueAsString(list);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
	
	@RequestMapping("/insertOrders.do")
	public ModelAndView insertOrder(OrderInfo info) {
		ModelAndView mv = new ModelAndView();
		int re = dao.insertOrder(info);
		String msg = "주문성공";
		
		if(re != 1) {
			msg = "주문실패";
		}
		System.out.println("아이디 : " + info.getId());
		System.out.println("배송지 : " + info.getAddr());
		System.out.println("총구매액 : " + info.getTotal());
		System.out.println("주문상품수 : " + info.getItems().size());
		
		mv.addObject("msg", msg);
		return mv;
	}
	
	
}
