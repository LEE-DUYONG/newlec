package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.service.NoticeService;
import com.newlec.service.NoticeServiceImpl;

public class NoticeRegProcController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		NoticeService noticeService = new NoticeServiceImpl();
		noticeService.noticeRegProc();
		
		return null;
	}

}
