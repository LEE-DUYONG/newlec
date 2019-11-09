package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.MemberVO;
import com.newlec.service.UserServiceImpl;

public class JoinProcController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("JoinProcController");
		MemberVO memberVO = new MemberVO();
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		
		memberVO.setId(request.getParameter("uid"));
		memberVO.setPassword(request.getParameter("pwd"));
		memberVO.setUserName(request.getParameter("name"));
		memberVO.setSex(request.getParameter("gender").charAt(0)); // F or M 한글자
		memberVO.setPhoneNumber(request.getParameter("cphone"));
		memberVO.setEmail(request.getParameter("email"));
		
		System.out.println(memberVO.toString());
		
		int result = 0;
		try {
			result = userServiceImpl.joinUser(memberVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(result == 0) {
			System.out.println("가입 실패");
			return "dispatcher:/joinus/join.jsp";
		} else {
			System.out.println("가입 성공");
			return "dispatcher:/joinus/login.jsp";
		}
		
	}

}
