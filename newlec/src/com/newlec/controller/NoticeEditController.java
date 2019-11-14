package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.NoticeBoardVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeEditController implements Controller {
	
	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeEditController");
		NoticeBoardVO notice = null;
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
		
		// 현재 페이지
		int curPage = 1;
		if(request.getParameter("page") != null) {
			curPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", curPage);
		
		// 게시글 번호
		int contentNum = 1;
		if(request.getParameter("contentNum") != null) {
			contentNum = Integer.parseInt(request.getParameter("contentNum"));
		}
		request.setAttribute("contentNum", contentNum);
		
		try {
			notice = noticeServiceImpl.noticeDetail(contentNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(notice.toString());
		request.setAttribute("notice", notice);
		
		return "dispatcher:/customer/noticeEdit.jsp";
	}
	
}
