package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.OrderInfo;
import com.bit.vo.GoodsVO;
import com.bit.vo.OrdersDetailVo;

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
		SqlSession session = factory.openSession();
		List<GoodsVO> list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	
	public static GoodsVO detail(int no) {
		Map map = new HashMap();
		map.put("no", no);
		SqlSession session = factory.openSession();
		GoodsVO g = session.selectOne("goods.detail", map);
		session.close();
		return g;
	}
	
	public static int insert(GoodsVO g) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("goods.insert", g);
		session.commit();
		session.close();
		return re;
	}
	//주문서 작성
	public static int insertOrders(OrderInfo info) {
		int re = -1;
		
		int cnt = 0;
		//해야할 sql문 수
		int okCnt = info.getItems().size()*2 + 1;
		
		SqlSession session = factory.openSession();
		//새로운 주문을 위한 주문번호
		//상세내역에서 참조됨
		int no = session.selectOne("goods.nextOrdersNo");
		HashMap orderMap = new HashMap();
		orderMap.put("no", no);
		orderMap.put("id", info.getId());
		orderMap.put("total", info.getTotal());
		orderMap.put("addr", info.getAddr());
		
		
		
		cnt += session.insert("goods.insertOrders", orderMap);
		
		for(OrdersDetailVo od : info.getItems()) {
			HashMap detail = new HashMap();
			detail.put("gno", od.getNo());
			detail.put("qty", od.getQty());
			detail.put("ono", no);
			
			cnt += session.insert("goods.insertDetail", detail);
			cnt += session.update("goods.downQty", detail);
		}
		
		if(cnt == okCnt) {
			session.commit();
			re = 1;
		} else {
			session.rollback();
		}
		
		session.close();
		return re;
	}
	
	//주문 상세내역
	public static int insertDetail(OrdersDetailVo od) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("goods.insertDetail", od);
		session.commit();
		session.close();
		return re;
	}
}
