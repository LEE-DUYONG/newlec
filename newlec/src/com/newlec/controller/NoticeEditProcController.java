package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.controller.Controller;
import com.newlec.domain.NoticeBoardVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeEditProcController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeEditProcController");
		NoticeBoardVO notice = new NoticeBoardVO();
		
		// 현재 페이지
		int curPage;
		if(request.getParameter("curPage") == null) {
			curPage = 1;
		} else {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
		// 게시글 번호
		int contentNum;
		if(request.getParameter("contentNum") == null) {
			contentNum = 1; // 나중에 실패처리 추가
			System.out.println("게시글 번호 불러오기 실패");
		} else {
			contentNum = Integer.parseInt(request.getParameter("contentNum"));
		}
		

		
		
		notice.setNum(contentNum);
		notice.setTitle(request.getParameter("noticeTitle"));
		notice.setContent(request.getParameter("noticeContent"));
		System.out.println("NoticeEditProcController notice.setContent()");
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
		
		
		int result = 0;
		try {
			// 나중에 게시글 유저 체크 추가
			result = noticeServiceImpl.noticeEdit(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(result == 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
		return "dispatcher:/customer/noticeDetail.jsp?curPage="+curPage+"&contentNum="+contentNum;
	}

}
