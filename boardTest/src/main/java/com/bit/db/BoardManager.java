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
		// 프로젝트 실행시에 실행됨
		try {
			/*
			 * 못 외우겠으면 공식사이트 참고 String resource = "com/bit/db/boardConfig.xml"; InputStream
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

	public static List<BoardVO> listAll() {
		List<BoardVO> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("board.selectAll");
		session.close();
		return list;
	}

	public static int insert(BoardVO b, HttpServletRequest request) {
		/*
		 * 답글일 때의 처리
		 b_ref : 부모글의 b_ref와 동일
		 b_level: 부모글의 b_level+1로 설정
		 b_step: 부모글의 b_step+1로 설정한다.
		 
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
			
			//이미 달려있는 답글들의 b_step을 증가
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
		// 답글과 관계있는 칼럼
		// b_ref, b_level, b_step
		// 최상위부모글일때의 처리
		// b_ref는 글번호와 동일하게 한다.
		// b_level과 b_step은 0으로 설정

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
