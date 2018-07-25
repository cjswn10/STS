package com.bit.advice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.db.ExceptionManager;

@Aspect
public class ControllerAdvice {

	@Pointcut("execution(public * com.bit.aopspring..*(..))")
	public void cAdvice() {
		
	}
	/*
	@Before("cAdvice()")
	public void before(JoinPoint joinPoint) {
		
		String svname = "";
		Object[] objs = joinPoint.getArgs();
		for(Object obj : objs) {
			if(obj instanceof HttpServletRequest) {
				svname = ((HttpServletRequest)obj).getRequestURI();
			}
		}
		System.out.println("어드바이스가 동작하였씁니다");
		System.out.println("서비스명: " + svname);
	}
	*/
	@AfterThrowing(pointcut="cAdvice()", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		String svname = "";
		String extype = ex.getMessage();
		
		Object[] objs = joinPoint.getArgs();
		for(Object obj : objs) {
			if(obj instanceof HttpServletRequest) {
				svname = ((HttpServletRequest)obj).getRequestURI();
			}
		}
		System.out.println("afterThrowing동작함");
		System.out.println("서비스명: " + svname);
		System.out.println("예외타입: " + extype);
		Map map = new HashMap();
		map.put("svname", svname);
		map.put("extype", extype);
		
		ExceptionManager.insert(map);
		
	}
}
