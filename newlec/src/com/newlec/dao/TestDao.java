package com.newlec.dao;

import com.newlec.domain.MemberVO;

public interface TestDao {
	String retrieveDate() throws Exception;
	void getMemberList();
	void insertMember(MemberVO member);
}
