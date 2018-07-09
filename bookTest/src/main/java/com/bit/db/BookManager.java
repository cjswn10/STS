package com.bit.db;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.InfoVO;

public class BookManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/db/mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<InfoVO> listInfo(Map map) {
		SqlSession session = factory.openSession();
		List list = session.selectList("info.selectInfo", map);
		session.close();
		return list;
	}
	
}
