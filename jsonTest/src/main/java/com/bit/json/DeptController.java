package com.bit.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.vo.DeptVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DeptController {
	@RequestMapping(value="/test.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String test() {
		DeptVO d = new DeptVO(100, "������", "�ż���");
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(d);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return str;
	}
}
