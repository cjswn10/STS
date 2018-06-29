package com.bit.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.DeptVO;

public class DeptManager {
	private static SqlSessionFactory factory;

	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/db/mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<DeptVO> listAll() {
		List<DeptVO> list = null;
    	SqlSession session = factory.openSession();
    	list = session.selectList("dept.selectAll");
    	session.close();
    	return list;
	}
	
	public static int insert(DeptVO d) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("dept.insert", d);
		session.close();
		return re;
	}
	
	public static DeptVO getDept(int dno) {
		DeptVO d = new DeptVO();
		SqlSession session = factory.openSession();
		d = session.selectOne("dept.getDept", dno);
		session.close();
		return d;
	}
	
	public static int update(DeptVO d) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("dept.update", d);
		session.close();
		return re;
	}
	
	public static int delete(int dno) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("dept.delete", dno);
		session.close();
		return re;
	}
}
