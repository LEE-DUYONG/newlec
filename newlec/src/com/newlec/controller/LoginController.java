package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.service.UserServiceImpl;

public class LoginController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.loginUser();
		
		return "dispatcher:/joinus/login.jsp";
	}

}
