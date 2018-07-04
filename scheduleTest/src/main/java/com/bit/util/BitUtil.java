package com.bit.util;

import org.springframework.scheduling.annotation.Scheduled;

public class BitUtil {
	
	@Scheduled(cron="0 0 12, 18 * *")
	//매일 12시 18시마다
	//cron="초 분 시간 일 월")
	//@Scheduled(fixedRate=10000)
	//10초마다
	public void pro() {
		System.out.println("콜콜!!");
	}
}
