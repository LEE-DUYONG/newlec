package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.service.TestService;
import com.newlec.service.TestServiceImpl;

public class TestController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Test!");
		
		TestService testService = new TestServiceImpl();
		String curDate = testService.retrieveDate();
		
		request.setAttribute("curDate", curDate);
		
		return "dispatcher:/WEB-INF/test.jsp";
		
		// ������ : dispatcher:/customer/notice.jsp
		// �����̷�Ʈ : sendRedirect:notice.html
	}

}
