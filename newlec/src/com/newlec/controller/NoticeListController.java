package com.newlec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.NoticeBoardVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeListController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeListController");
		List<NoticeBoardVO> noticeList = null;
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();

		// 현재 페이지
		int curPage;
		if(request.getParameter("curPage") == null) {
			curPage = 1;
		} else {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
		try {
			noticeList = noticeServiceImpl.noticeMain(curPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("curPage", curPage);
		request.setAttribute("noticeList", noticeList);
		
		return "dispatcher:/customer/notice.jsp?curPage="+curPage;
	}

}
