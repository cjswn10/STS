package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.BoardVO;

public class BoardManager {
	private static SqlSessionFactory factory;
	static {
		// ������Ʈ ����ÿ� �����
		try {
			/*
			 * �� �ܿ������ ���Ļ���Ʈ ���� String resource = "com/bit/db/boardConfig.xml"; InputStream
			 * inputStream = Resources.getResourceAsStream(resource); factory = new
			 * SqlSessionFactoryBuilder().build(inputStream);
			 */
			Reader reader = Resources.getResourceAsReader("com/bit/db/boardConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static List<BoardVO> listAll(Map map) {
		List<BoardVO> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("board.selectAll", map);
		session.close();
		return list;
	}

	public static List<BoardVO> myList(String id) {
		List<BoardVO> list = null;
		Map map = new HashMap();
		map.put("id", id);
		SqlSession session = factory.openSession();
		list = session.selectList("board.myList", map);
		session.close();
		return list;
	}
	
	public static int insert(BoardVO b, HttpServletRequest request) {
		/*
		 * ����� ���� ó��
		 b_ref : �θ���� b_ref�� ����
		 b_level: �θ���� b_level+1�� ����
		 b_step: �θ���� b_step+1�� �����Ѵ�.
		 
		 */
		int pno = b.getNo();
		
		int no = getNextNo();
		b.setNo(no);

		int b_ref = no;
		int b_step = 0;
		int b_level = 0;

		if(pno != 0) {
			BoardVO p = detail(pno);
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();
			
			//�̹� �޷��ִ� ��۵��� b_step�� ����
			Map map = new HashMap();
			map.put("b_ref", b_ref);
			map.put("b_step", b_step);
			updateStep(map);
			
			b_level++;
			b_step++;
		}
			
			
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		// ��۰� �����ִ� Į��
		// b_ref, b_level, b_step
		// �ֻ����θ���϶��� ó��
		// b_ref�� �۹�ȣ�� �����ϰ� �Ѵ�.
		// b_level�� b_step�� 0���� ����

		b.setIp(request.getRemoteAddr());

		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("board.insert", b);
		session.close();
		return re;
	}

	private static int updateStep(Map map) {
		// TODO Auto-generated method stub
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("board.updateStep", map);
		session.close();
		return re;
	}

	public static int getNextNo() {
		int no = 0;
		SqlSession session = factory.openSession();
		no = session.selectOne("board.nextNo");
		session.close();
		return no;
	}

	public static BoardVO detail(int no) {
		BoardVO b = new BoardVO();
		SqlSession session = factory.openSession();
		Map map = new HashMap();
		map.put("no", no);
		b = session.selectOne("board.detail", map);
		session.close();
		b.setHit(updateHit(no));
		return b;
	}

	public static int updateHit(int no) {
    	Map map = new HashMap();
    	map.put("no", no);
    	int re = -1;
    	SqlSession session = factory.openSession(true);
    	re = session.update("board.updateHit", map);
    	session.close();
    	return re;
    }

	public static int update(BoardVO b) {
		int re = -1;
		b.setFsize(0);
		SqlSession session = factory.openSession(true);
		re = session.update("board.update", b);
		session.close();
		return re;
	}

	public static int delete(int no) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		Map map = new HashMap();
		map.put("no", no);
		re = session.update("board.delete", map);
		session.close();
		return re;
	}
}
