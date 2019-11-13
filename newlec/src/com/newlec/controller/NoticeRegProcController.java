package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlec.domain.LoginDTO;
import com.newlec.domain.NoticeBoardVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeRegProcController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeRegProcController");
		NoticeBoardVO notice = new NoticeBoardVO();
		
		// 게시글 정보 받아오기
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		notice.setCreatedDate(sqlDate);
		
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();

		int result = 0;
		HttpSession  session = request.getSession(true);
		LoginDTO loginDTO = (LoginDTO) session.getAttribute("loginDTO");
		System.out.println(loginDTO.getId());
		System.out.println(loginDTO.getId().substring(loginDTO.getId().lastIndexOf("(")+1));
		String userid = loginDTO.getId().substring(loginDTO.getId().lastIndexOf("(")+1);
		// 게시글 번호
		int contentNum = 0;
		try {
			//게시글 작성
			// 나중에 게시글 유저 체크 추가
			result = noticeServiceImpl.noticeRegProc(notice, userid);
//			System.out.println("NoticeRegProcController - noticeRegProc - result : "+result);
			
			// 유저의 가장 최신 게시글 번호 받아오기
			// result = noticeServiceImpl.curNoticeNum(userId);
			contentNum = noticeServiceImpl.newNoticeNum(userid);
			
			notice = noticeServiceImpl.noticeDetail(contentNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result == 0) {
			System.out.println("등록 실패");
		} else {
			System.out.println("등록 성공");
		}
		
		if(contentNum == 0) {
			System.out.println("가장 최신 게시글 번호 받아오기 실패");
		} else {
			System.out.println("가장 최신 게시글 번호 받아오기 성공");
		}
		
		request.setAttribute("contentNum", contentNum);
		
		
		if(notice == null) {
			System.out.println("게시글 불러오기 실패");
		} else {
			System.out.println("게시글 불러오기 성공");
		}
		
		System.out.println(notice.toString());
		request.setAttribute("notice", notice);
		
		
		return "dispatcher:/customer/noticeDetail.jsp";
	}

}
