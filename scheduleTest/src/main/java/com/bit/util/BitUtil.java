package com.bit.util;

import org.springframework.scheduling.annotation.Scheduled;

public class BitUtil {
	
	@Scheduled(cron="0 0 12, 18 * *")
	//���� 12�� 18�ø���
	//cron="�� �� �ð� �� ��")
	//@Scheduled(fixedRate=10000)
	//10�ʸ���
	public void pro() {
		System.out.println("����!!");
	}
}
