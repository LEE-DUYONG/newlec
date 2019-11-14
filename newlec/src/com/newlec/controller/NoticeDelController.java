package com.newlec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.NoticeBoardVO;
import com.newlec.domain.PageVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeDelController implements Controller {
	
	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeDelController");
		List<NoticeBoardVO> noticeList = null;
		PageVO pageVO = null;
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
		
		// 현재 페이지
		int curPage = 1;
		if(request.getParameter("page") != null) {
			curPage = Integer.parseInt(request.getParameter("page"));
		}
		
		// 게시글 번호
		int contentNum = 1;
		if(request.getParameter("contentNum") != null) {
			contentNum = Integer.parseInt(request.getParameter("contentNum"));
		}
		
		// sql 결과
		int result = 0;
		try {
			// 게시글 삭제
			result = noticeServiceImpl.noticeDel(contentNum);
			
			// 페이징을 위한 페이지 정보 계산
			pageVO = noticeServiceImpl.noticePaging(curPage);
			
			// 게시판 리스트
			noticeList = noticeServiceImpl.noticeList(pageVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result == 0) {
			System.out.println("삭제 실패");
		} else {
			System.out.println("삭제 성공");
		}
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("noticeList", noticeList);
		request.removeAttribute("contentNum");
		
		return "sendRedirect:/newlec/notice.yjc?page="+curPage;
	}
	
}
