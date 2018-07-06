package com.bit.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.MemberManager;

@Repository
public class MemberDAO {
	public Boolean isMember(Map map) {
		return MemberManager.isMember(map);
	}
}
