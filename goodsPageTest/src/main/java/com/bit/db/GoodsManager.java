package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.GoodsVO;

public class GoodsManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/db/goodsConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<GoodsVO> listAll() {
		List<GoodsVO> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}

	public static int insert(GoodsVO g) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("goods.insert", g);
		session.close();
		return re;
	}
}
