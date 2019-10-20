package com.newlec.service;

import com.newlec.domain.MemberVO;

public interface TestService {
	String retrieveDate() throws Exception;
	void getListMember() throws Exception;
	void registerMember(MemberVO member) throws Exception;
}
