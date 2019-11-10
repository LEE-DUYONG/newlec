package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlec.domain.LoginDTO;
import com.newlec.domain.MemberVO;
import com.newlec.service.UserServiceImpl;

public class LoginProcController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginProcController");
		MemberVO memberVO = new MemberVO();
		LoginDTO loginDTO = new LoginDTO();
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		
		memberVO.setId(request.getParameter("UserName"));
		memberVO.setPassword(request.getParameter("Password"));
		
		System.out.println(memberVO.toString());
		

		try {
			loginDTO = userServiceImpl.loginUser(memberVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(loginDTO.toString());
		
		if(null != loginDTO.getUserName()) {
			System.out.println("로그인 성공");
			HttpSession  session = request.getSession(true);
			session.setAttribute("loginDTO", loginDTO);
			return "dispatcher:/index.jsp";
		} else {
			System.out.println("로그인 실패");
			return "dispatcher:/joinus/login.jsp";
		}
	}

}
