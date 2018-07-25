package com.bit.dao;

public class BoardDao {
	public void insert() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("게시물을 등록하였습니다.");
	}
	
	
}
