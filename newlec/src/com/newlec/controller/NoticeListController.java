package com.newlec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.NoticeBoardVO;
import com.newlec.domain.PageVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeListController implements Controller {
	
	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeListController");
		List<NoticeBoardVO> noticeList = null;
		PageVO pageVO = new PageVO();
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
		
		// 현재 페이지
		int curPage = 1;
		if(request.getParameter("page") != null) {
			curPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", curPage);

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
			
			// 검색어 및 카테고리 입력
			pageVO.setSearchCategory(searchCategory);
			pageVO.setSearchKeyword(searchKeyword);
			
			// 페이징을 위한 페이지 정보 계산
			pageVO = noticeServiceImpl.noticePaging(curPage, pageVO);
			System.out.println("pageVO : "+pageVO.toString());
			
			// 게시판 리스트
			noticeList = noticeServiceImpl.noticeList(pageVO);
			System.out.println("noticeList 조회 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("noticeList", noticeList);
		
		return "dispatcher:/customer/notice.jsp";
	}
	
}
