package com.newlec.controller;

import java.util.List;

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
		List<NoticeBoardVO> noticeList = null;
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
		
		int result = 0;
		
		try {
			// 나중에 유저이름체크도 추가
			result = noticeServiceImpl.noticeDel(contentNum);
			noticeList = noticeServiceImpl.noticeList(curPage);
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
