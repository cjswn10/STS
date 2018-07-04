package com.bit.db;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.AccountVO;

public class AccountManager {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/db/accountConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static int transfer(Map map) {
		int r = -1;
		
		int amount = (Integer) map.get("amount");
		if( amount < 0) {
			r = -2;
			return r;
		}
		
		int withdraw = -1;
		int deposit = -1;
		
		SqlSession session = factory.openSession();
		AccountVO fAccount = new AccountVO();
		AccountVO tAccount = new AccountVO();
		fAccount = session.selectOne("account.getAccount", map.get("from"));
		tAccount = session.selectOne("account.getAccount", map.get("to"));
		
		if(fAccount == null) {
			r = -3;
			return r;
		}
		
		if(tAccount == null) {
			r = -4;
			return r;
		}
		
		if(fAccount.getBalance() > amount) { 
			withdraw = session.update("account.withdraw", map);		
			deposit = session.update("account.deposit", map);
		}
		
		if(withdraw > 0 && deposit > 0) {
			session.commit();
			r = 1;
		} else {
			session.rollback();
		}
		session.close();
		return r;
	}
	
	
}
