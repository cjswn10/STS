package com.bit.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class BitAdvice {
   // around 어드바이스 이외의 어드바이스는
   // joinPoint를 선택적으로 가질 수 있다.
   // 타깃이 되는 메소드가 예외를 안고 비정상적으로 완료되었을때
   // 수행하는 afterThrowing 어드바이스에서
   // 만약에 타깃이 되는 메소드의 정보즉 JoinPoint도 갖고
   // 또, 예외의 정보를 가져야 한다면
   // 반드시 JoinPoint를 첫번째 매개변수로 두어야 한다
   public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
      String methodName = joinPoint.getSignature().toShortString();
      System.out.println("타깃이 되는 메소드에서("+methodName+") 문제가 발생하였습니다");
      //System.out.println("타깃이 되는 메소드에서문제가 발생하였습니다");
      System.out.println(ex.getMessage());
   }

   public void afterReturning(JoinPoint joinPoint, Object obj) {
      System.out.println("*************************************************");
      String methodName = joinPoint.getSignature().toShortString();
      System.out.println("타깃이 되는 메소드(" + methodName + ")가 정상작동 하였습니다.");
      System.out.println("타깃이 반환하는 값: ");
      System.out.println(obj);
      System.out.println("*************************************************");
   }

   public void after(JoinPoint joinPoint) {
      String methodName = joinPoint.getSignature().toShortString();
      System.out.println("타깃이 되는 메소드(" + methodName + ")가 완료되었습니다.");
   }

   // Around Advice이외의 어드바ㅓ이스는
   // Join Point를 매개변수를 가지지 않아도 가능하다
   // 필요하다면(타깃이 되는 메소드의 정보) 선택적으로 가질 수 있다
   // public void before() {
   public void before(JoinPoint joinPoint) {
      String longMethod = joinPoint.getSignature().toLongString();
      String shortMethod = joinPoint.getSignature().toShortString();
      System.out.println("핵심 메소드가 실행하기 전입니다.");
      System.out.println(longMethod);
      System.out.println(shortMethod);
      System.out.println("*************************************************");
   }

   public Object pro(ProceedingJoinPoint joinPoint) throws Throwable {

      Object obj = null;

      String methoName = joinPoint.getSignature().toShortString();
      System.out.println(methoName + "시작");
      long start = System.currentTimeMillis();

      obj = joinPoint.proceed();

      System.out.println(methoName + "종료");
      long end = System.currentTimeMillis();
      System.out.println("걸린시간: " + (end - start));
      return obj;

   }

}