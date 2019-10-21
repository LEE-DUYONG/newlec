package com.newlec.service;

import com.newlec.domain.MemberVO;

public class UserServiceImpl implements UserService {

	@Override
	public void joinUser(MemberVO memberVO) throws Exception { // 회원가입
		// TODO Auto-generated method stub
		
		// com.newlec.dao에서 회원가입DAO를 사용해 유저 정보를 확인 후 DB에 넣는다.
		// new OracleTestDao().insertMember(member); 와 같은 형식
	}

	@Override
	public void loginUser() throws Exception { // 로그인
		// TODO Auto-generated method stub
		
		// com.newlec.dao에서 로그인DAO를 사용해 유저 ID/PW를 확인 후 정보를 받아 세션에 넣는다.
		// new OracleTestDao().getMemberList(); 와 같은 형식
	}

}
