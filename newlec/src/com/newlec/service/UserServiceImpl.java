package com.newlec.service;

import com.newlec.dao.OracleMemberDao;
import com.newlec.domain.LoginDTO;
import com.newlec.domain.MemberVO;

public class UserServiceImpl implements UserService {
	
	@Override
	public int joinUser(MemberVO memberVO) throws Exception { // 회원가입
		// TODO Auto-generated method stub
		System.out.println("joinUser");
		OracleMemberDao oracleMemberDao = new OracleMemberDao();
		return oracleMemberDao.insertMember(memberVO);
	}
	
	@Override
	public LoginDTO loginUser(MemberVO memberVO) throws Exception { // 로그인
		// TODO Auto-generated method stub
		System.out.println("loginUser");
		
		LoginDTO loginDTO = new LoginDTO();
		
		OracleMemberDao oracleMemberDao = new OracleMemberDao();
		memberVO = oracleMemberDao.getMemberLoginInfo(memberVO);
		
		loginDTO.setId(memberVO.getId());
		loginDTO.setUserName(memberVO.getUserName());
		
		return loginDTO;
	}
	
	@Override
	public String joinUserIdCk(String id) throws Exception { // 회원가입 id 중복확인
		System.out.println("joinUserIdCk");
		
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
