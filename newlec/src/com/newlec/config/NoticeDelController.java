package com.newlec.config;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.controller.Controller;
import com.newlec.domain.NoticeBoardVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeDelController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeDelController");
		ArrayList<NoticeBoardVO> noticeList = null;
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();

		// 현재 페이지
		int curPage;
		if(request.getParameter("curPage") == null) {
			curPage = 1;
		} else {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
		int result = 0;
		
		try {
			result = noticeServiceImpl.noticeDel();
			noticeList = noticeServiceImpl.noticeMain(curPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result == 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		request.setAttribute("curPage", curPage);
		request.setAttribute("noticeList", noticeList);
		
		return "dispatcher:/customer/notice.jsp?curPage="+curPage;
	}

}
