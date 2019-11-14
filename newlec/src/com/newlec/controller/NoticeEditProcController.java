package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.NoticeBoardVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeEditProcController implements Controller {
	
	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeEditProcController");
		NoticeBoardVO notice = new NoticeBoardVO();
		NoticeBoardVO nextTitle = null;
		NoticeBoardVO previousTitle = null;
		
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
		
		notice.setNum(contentNum);
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
		
		int result = 0;
		try {
			// sql문 결과
			result = noticeServiceImpl.noticeEdit(notice);
			
			// 수정한 게시글 불러오기
			notice = noticeServiceImpl.noticeDetail(contentNum);
			
			// 현재 게시글의 rownum 구하기
			int rownum = noticeServiceImpl.noticeCurRownum(contentNum);
			
			// 현재 게시글의 다음, 이전 제목 검색하기
			nextTitle = noticeServiceImpl.noticeNextTitle(rownum);
			previousTitle = noticeServiceImpl.noticePreviousTitle(rownum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result == 0) {
			System.out.println("수정 실패");
		} else {
			System.out.println("수정 성공");
		}
		
		if(notice == null) {
			System.out.println("게시글 불러오기 실패");
		} else {
			System.out.println("게시글 불러오기 성공");
		}
		System.out.println(notice.toString());
		request.setAttribute("notice", notice);
		
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
		
		return "sendRedirect:/newlec/noticeDetail.yjc?page="+curPage+"&contentNum="+contentNum;
	}
	
}
