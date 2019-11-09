package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProcController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginProcController");
		
		return "dispatcher:/joinus/login.jsp";
	}

}
