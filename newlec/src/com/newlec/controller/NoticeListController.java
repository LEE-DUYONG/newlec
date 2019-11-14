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
		PageVO pageVO = null;
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
		
		// 현재 페이지
		int curPage = 1;
		if(request.getParameter("page") != null) {
			curPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", curPage);
		
		try {
			// 페이징을 위한 페이지 정보 계산
			pageVO = noticeServiceImpl.noticePaging(curPage);
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
