package com.bit.dao;

import java.util.ArrayList;

public class MemberDao {
	public void insertMember(String id, String pwd) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//int a = 4/0;
		System.out.println(id + "�� ������ �߰��Ͽ����ϴ�.");
	}
	
	public int deleteMember(String id) {
		try {
			Thread.sleep(3500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(id + "�� ������ �����Ͽ����ϴ�.");
		return 1;
	}
	
	public ArrayList<String> listAll(){
	      ArrayList<String> list = new ArrayList<String>();
	      list.add("ȫ�浿");
	      list.add("������");
	      list.add("�̼���");
	      return list;
	}
}
