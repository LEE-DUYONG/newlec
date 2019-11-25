package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeRegController implements Controller {
	
	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeRegController");
		
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
		
		// 검색 카테고리 TITLE or CONTENT
		String searchCategory = "TITLE";
		if(request.getParameter("f") != null) {
			searchCategory = request.getParameter("f");
			System.out.println("searchCategory:"+searchCategory);
			request.setAttribute("f", searchCategory);
		}
		
		// 검색어
		String searchKeyword = null;
		if(request.getParameter("q") != null) {
			searchKeyword = request.getParameter("q");
			System.out.println("searchKeyWord:"+searchKeyword);
			request.setAttribute("q", searchKeyword);
		}
		
		return "dispatcher:/customer/noticeReg.jsp";
	}
	
}
