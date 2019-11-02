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
		
		// 게시글 번호
		int contentNum;
		if(request.getParameter("contentNum") == null) {
			contentNum = 1; // 나중에 실패처리 추가
			System.out.println("게시글 번호 불러오기 실패");
		} else {
			contentNum = Integer.parseInt(request.getParameter("contentNum"));
		}
		
		notice.setNum(contentNum);
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
//		System.out.println("NoticeEditProcController notice.setContent()");
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
		
		
		int result = 0;
		try {
			// 나중에 게시글 유저 체크 추가
			result = noticeServiceImpl.noticeEdit(notice);
			
			notice = noticeServiceImpl.noticeDetail(contentNum);
			

			// 현재 게시글의 이전, 다음글 제목 검색하기
			nextTitle = noticeServiceImpl.noticeNextTitle(contentNum);
			previousTitle = noticeServiceImpl.noticePreviousTitle(contentNum);
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
		
		

		return "dispatcher:/customer/noticeDetail.jsp";
	}

}
