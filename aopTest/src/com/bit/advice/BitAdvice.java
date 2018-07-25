package com.bit.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class BitAdvice {
   // around �����̽� �̿��� �����̽���
   // joinPoint�� ���������� ���� �� �ִ�.
   // Ÿ���� �Ǵ� �޼ҵ尡 ���ܸ� �Ȱ� ������������ �Ϸ�Ǿ�����
   // �����ϴ� afterThrowing �����̽�����
   // ���࿡ Ÿ���� �Ǵ� �޼ҵ��� ������ JoinPoint�� ����
   // ��, ������ ������ ������ �Ѵٸ�
   // �ݵ�� JoinPoint�� ù��° �Ű������� �ξ�� �Ѵ�
   public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
      String methodName = joinPoint.getSignature().toShortString();
      System.out.println("Ÿ���� �Ǵ� �޼ҵ忡��("+methodName+") ������ �߻��Ͽ����ϴ�");
      //System.out.println("Ÿ���� �Ǵ� �޼ҵ忡�������� �߻��Ͽ����ϴ�");
      System.out.println(ex.getMessage());
   }

   public void afterReturning(JoinPoint joinPoint, Object obj) {
      System.out.println("*************************************************");
      String methodName = joinPoint.getSignature().toShortString();
      System.out.println("Ÿ���� �Ǵ� �޼ҵ�(" + methodName + ")�� �����۵� �Ͽ����ϴ�.");
      System.out.println("Ÿ���� ��ȯ�ϴ� ��: ");
      System.out.println(obj);
      System.out.println("*************************************************");
   }

   public void after(JoinPoint joinPoint) {
      String methodName = joinPoint.getSignature().toShortString();
      System.out.println("Ÿ���� �Ǵ� �޼ҵ�(" + methodName + ")�� �Ϸ�Ǿ����ϴ�.");
   }

   // Around Advice�̿��� ���٤��̽���
   // Join Point�� �Ű������� ������ �ʾƵ� �����ϴ�
   // �ʿ��ϴٸ�(Ÿ���� �Ǵ� �޼ҵ��� ����) ���������� ���� �� �ִ�
   // public void before() {
   public void before(JoinPoint joinPoint) {
      String longMethod = joinPoint.getSignature().toLongString();
      String shortMethod = joinPoint.getSignature().toShortString();
      System.out.println("�ٽ� �޼ҵ尡 �����ϱ� ���Դϴ�.");
      System.out.println(longMethod);
      System.out.println(shortMethod);
      System.out.println("*************************************************");
   }

   public Object pro(ProceedingJoinPoint joinPoint) throws Throwable {

      Object obj = null;

      String methoName = joinPoint.getSignature().toShortString();
      System.out.println(methoName + "����");
      long start = System.currentTimeMillis();

      obj = joinPoint.proceed();

      System.out.println(methoName + "����");
      long end = System.currentTimeMillis();
      System.out.println("�ɸ��ð�: " + (end - start));
      return obj;

   }

}