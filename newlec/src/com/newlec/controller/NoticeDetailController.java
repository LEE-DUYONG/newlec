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
			contentNum = 1; // 나중에 에러메세지와 뒤로가기 작동으로 변경
		} else {
			contentNum = Integer.parseInt(request.getParameter("contentNum"));
		}
		
		System.out.println("contentNum : "+contentNum);
		try {
			notice = noticeServiceImpl.noticeDetail(contentNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(notice.toString());
		request.setAttribute("notice", notice);
		
		return "dispatcher:/customer/noticeDetail.jsp?curPage="+curPage+"&contentNum="+contentNum;
	}

}
