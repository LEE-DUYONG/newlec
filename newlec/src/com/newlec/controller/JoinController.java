package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.MemberVO;
import com.newlec.service.UserServiceImpl;

public class JoinController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// 회원정보 입력
		MemberVO memberVO = new MemberVO();
		memberVO.setId("");
		memberVO.setUserName("");
		memberVO.setPassword("");
		memberVO.setSex('M');
		memberVO.setEmail("");
		memberVO.setPhoneNumber("");
		
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.joinUser(memberVO);
		
		return "dispatcher:/joinus/join.jsp";
	}

}
