package com.newlec.service;

import com.newlec.domain.MemberVO;

public interface UserService {
	MemberVO joinUser() throws Exception;
	MemberVO loginUser() throws Exception;
}
