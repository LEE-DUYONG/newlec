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
		// UserServiceImpl userServiceImpl = new UserServiceImpl();
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();

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
		
		try {
			// 나중에 게시글 작성자 확인
			// userServiceImpl.userCheck(contentNum, userId);
			notice = noticeServiceImpl.noticeDetail(contentNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(notice.toString());
		request.setAttribute("notice", notice);
		
		return "dispatcher:/customer/noticeEdit.jsp?curPage="+curPage+"&contentNum="+contentNum;
	}

}
