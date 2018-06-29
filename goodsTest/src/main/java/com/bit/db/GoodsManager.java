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
	
	public static List<GoodsVO> listAll(Map map) {
		List<GoodsVO> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.selectAll", map);
		session.close();
		return list;
	}
	
	public static GoodsVO getGoods(int no) {
		GoodsVO g = new GoodsVO();
		Map map = new HashMap();
		map.put("no", no);
		SqlSession session = factory.openSession();
		g = session.selectOne("goods.detail", map);
		return g;
	}
	
	public static int insert(GoodsVO g) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("goods.insert", g);
		session.close();
		return re;
	}
	
	
	public static int update(GoodsVO g) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("goods.update", g);
		session.close();
		return re;
	}
	
	public static int delete(int no) {
		int re = -1;
		Map map = new HashMap();
		map.put("no", no);
		SqlSession session = factory.openSession(true);
		re = session.delete("goods.delete", map);
		session.close();
		return re;
	}
}
