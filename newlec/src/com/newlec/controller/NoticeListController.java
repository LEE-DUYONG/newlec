package com.newlec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.domain.NoticeBoardVO;
import com.newlec.service.NoticeServiceImpl;

public class NoticeListController implements Controller {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeListController");
		List<NoticeBoardVO> noticeList = null;
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
		
		//int nowPage = (int) request.getAttribute("nowPage");
		
		//임시 할당
		int nowPage = 1;
		
		try {
			noticeList = noticeServiceImpl.noticeList(nowPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("noticeList", noticeList);
		
		return "dispatcher:/customer/notice.jsp";
	}

}
