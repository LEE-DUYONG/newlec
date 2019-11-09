package com.newlec.dao;

import com.newlec.domain.MemberVO;

public interface MemberDao {
	String retrieveDate() throws Exception;
	int findMemberId(String id) throws Exception;
	void getMemberList();
	int insertMember(MemberVO member);
	
	
}
