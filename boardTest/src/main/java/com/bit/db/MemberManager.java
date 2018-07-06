package com.bit.db;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.MemberVO;

public class MemberManager {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/db/boardConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<MemberVO> listAll() {
		SqlSession session = factory.openSession();
		List<MemberVO> list = session.selectList("members.selectAll");
		session.close();
		return list;
	}
	
	public static int insert(MemberVO m) {
		int re = 01;
		SqlSession session = factory.openSession();
		re = session.insert("members.insert", m);
		session.commit();
		session.close();
		return re;
	}
	
	public static Boolean isMember(Map map) {
		boolean r = false;
		SqlSession session = factory.openSession();
		MemberVO m = session.selectOne("members.isMember", map);
		if(m != null) {
			r = true;
		}
		session.close();
		return r;
	}
	
}
