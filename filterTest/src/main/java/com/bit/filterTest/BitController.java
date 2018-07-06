package com.bit.filterTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BitController {

	//특정페이지들에만 필터를 적용하고 싶을때
	//namespace를 이용하는 방법
	//web.xml에도 추가
	@RequestMapping("member/c.do")
	public void c() {
	}
	
	@RequestMapping("member/d.do")
	public void d() {
	}
	
	@RequestMapping("manager/e.do")
	public void e() {
	}
	
	@RequestMapping("manager/f.do")
	public void f() {
	}
	
	
	@RequestMapping("a.do")
	public void a() {
		System.out.println("a실행");
	}
	
	@RequestMapping("b.do")
	public void b() {
		System.out.println("b실행");
	}
}
