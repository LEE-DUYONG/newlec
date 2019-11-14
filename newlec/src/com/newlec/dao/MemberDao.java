package com.newlec.dao;

import java.util.List;

import com.newlec.domain.MemberVO;

public interface MemberDao {
	String retrieveDate() throws Exception;
	int findMemberId(String id) throws Exception;
	List<MemberVO> getMemberList();
	MemberVO getMemberLoginInfo(MemberVO member);
	int insertMember(MemberVO member);
}
