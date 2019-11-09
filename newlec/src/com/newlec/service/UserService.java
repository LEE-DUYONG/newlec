package com.newlec.service;

import com.newlec.domain.MemberVO;

public interface UserService {
	int joinUser(MemberVO memberVO) throws Exception;
	String joinUserIdCk(String id) throws Exception;
	void loginUser() throws Exception;
}
