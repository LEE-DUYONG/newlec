package com.newlec.service;

import com.newlec.domain.MemberVO;

public interface UserService {
	void joinUser(MemberVO memberVO) throws Exception;
	void loginUser() throws Exception;
}
