package com.bit.name;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.dao.BoardDao;
import com.bit.dao.MemberDao;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bit/name/beans.xml");
		MemberDao mDao = (MemberDao)context.getBean("mDao");
		BoardDao bDao = (BoardDao)context.getBean("bDao");
		
		mDao.deleteMember("tiger");
		bDao.insert();
		mDao.insertMember("tiger", "tiger");
		ArrayList<String> list = mDao.listAll();
	      for(String name:list)
	      {
	         System.out.println(name);
	      }
		
	}
}
