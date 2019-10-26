package com.newlec.dao;

import com.newlec.domain.MemberVO;

public interface MemberDao {
	String retrieveDate() throws Exception;
	void getMemberList();
	void insertMember(MemberVO member);
	
	
}
