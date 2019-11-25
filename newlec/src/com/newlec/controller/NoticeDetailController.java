package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.NoticeBoardVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeDetailController implements Controller {
	
	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeDetailController");
		NoticeBoardVO notice = null;
		NoticeBoardVO nextTitle = null;
		NoticeBoardVO previousTitle = null;
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
		
		try {
			// 게시판 조회수 hit +1
			noticeServiceImpl.noticeHit(contentNum);
			
			// 게시글 불러오기
			notice = noticeServiceImpl.noticeDetail(contentNum);
			
			// 현재 게시글의 rownum 구하기
			int rownum = noticeServiceImpl.noticeCurRownum(contentNum);
			
			// 현재 게시글의 다음, 이전 제목 검색하기
			nextTitle = noticeServiceImpl.noticeNextTitle(rownum);
			previousTitle = noticeServiceImpl.noticePreviousTitle(rownum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(notice == null) {
			System.out.println("게시글 불러오기 실패");
		} else {
			System.out.println("게시글 불러오기 성공");
		}
		System.out.println(notice.toString());
		request.setAttribute("notice", notice);
		request.setAttribute("contentNum", notice.getNum());
		
		if(nextTitle == null) {
			System.out.println("다음 게시글 제목 불러오기 실패");
		} else {
			System.out.println("다음 게시글 제목 불러오기 성공");
		}
		System.out.println("nextTitle : "+nextTitle);
		request.setAttribute("nextTitle", nextTitle);
		
		if(previousTitle == null) {
			System.out.println("이전 게시글 제목 불러오기 실패");
		} else {
			System.out.println("이전 게시글 제목 불러오기 성공");
		}
		System.out.println("previousTitle : "+previousTitle);
		request.setAttribute("previousTitle", previousTitle);
		
		return "dispatcher:/customer/noticeDetail.jsp";
	}
	
}
