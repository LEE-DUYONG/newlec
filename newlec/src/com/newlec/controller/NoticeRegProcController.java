package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.NoticeBoardVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeRegProcController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeRegProcController");
		NoticeBoardVO notice = new NoticeBoardVO();
		

		// 현재 페이지
		int curPage;
		if(request.getParameter("curPage") == null) {
			curPage = 1;
		} else {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
		
		// 게시글 정보 받아오기
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		notice.setCreatedDate(sqlDate);
		
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
		
		int result = 0;
		try {
			// 나중에 게시글 유저 체크 추가
			result = noticeServiceImpl.noticeRegProc(notice);
			System.out.println("NoticeRegProcController - result : "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result == 0) {
			System.out.println("등록 실패");
		} else {
			System.out.println("등록 성공");
		}
		
		// 게시글 번호
		// 유저의 가장 최신 게시글 번호 받아오기
		int contentNum = 1;
		
		return "dispatcher:/customer/noticeDetail.jsp?curPage="+curPage+"&contentNum="+contentNum;
	}

}
