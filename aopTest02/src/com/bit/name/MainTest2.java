package com.bit.name;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.dao.BoardDao;
import com.bit.dao.MemberDao;

public class MainTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bit/name/beans02.xml");
		MemberDao mDao = (MemberDao)context.getBean("mDao");
		BoardDao bDao = (BoardDao)context.getBean("bDao");
		
		mDao.deleteMember("tiger");
		bDao.insert();
		ArrayList<String> list = mDao.listAll();
		for(String name:list)
		{
		   System.out.println(name);
		}
	}

}
