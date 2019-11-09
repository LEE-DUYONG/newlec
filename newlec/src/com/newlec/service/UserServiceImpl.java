package com.newlec.service;

import com.newlec.dao.OracleMemberDao;
import com.newlec.domain.MemberVO;

public class UserServiceImpl implements UserService {

	@Override
	public int joinUser(MemberVO memberVO) throws Exception { // 회원가입
		// TODO Auto-generated method stub


		OracleMemberDao oracleMemberDao = new OracleMemberDao();
		return oracleMemberDao.insertMember(memberVO);
	}

	@Override
	public void loginUser() throws Exception { // 로그인
		// TODO Auto-generated method stub
		
		// com.newlec.dao에서 로그인DAO를 사용해 유저 ID/PW를 확인 후 정보를 받아 세션에 넣는다.
		// new OracleTestDao().getMemberList(); 와 같은 형식
	}

	@Override
	public String joinUserIdCk(String id) throws Exception {
		
		
		OracleMemberDao oracleMemberDao = new OracleMemberDao();
		int dbIdCount = oracleMemberDao.findMemberId(id);
		
		String result = "";
		if ( 1 == dbIdCount ) {
			result = "NO";
		} else if ( 0 == dbIdCount ) {
			result = "OK";
		} else {
			result = "ERR";
		}
		
		System.out.println("result:"+result);
		
		return result;
		
	}

}
