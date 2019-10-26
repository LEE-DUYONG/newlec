package com.newlec.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.newlec.dao.NoticeBoardDao;
import com.newlec.dao.OracleNoticeBoardDao;
import com.newlec.domain.NoticeBoardVO;

public class NoticeServiceImpl implements NoticeService {
	
	@Override
	public ArrayList<NoticeBoardVO> noticeMain(int nowPage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl.noticeMain");
		
		// DAO와 연결해 게시판 리스트 불러오기
		// startRow와 endRow를 이용해 제한된 게시판 불러오기

		// 게시판 Row 임시 할당
		// DAO와 연결해 게시글 전체 수 불러오기
		int pageRow = 10; // 한 페이지당 출력하는 게시글 수
		int noticeCount = 15;
		int startRow = 0;
		int endRow = 0;
		
		// nowPage변수 임시 할당
		nowPage = 1;
		
		startRow = (nowPage * pageRow) - (pageRow - 1);
		
		if(noticeCount / pageRow <= nowPage * pageRow) {
			endRow = noticeCount;
		} else {
			endRow = startRow + 9;
		}
		
		
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		noticeBoardDao.getBoardList();
		
		ArrayList<NoticeBoardVO> noticeList = new ArrayList<NoticeBoardVO>();
		
		
		// 수동 데이터 입력
		
		for (int i = 1; i <= 5; i++) {
			NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
			noticeBoardVO.setNum(i);
			noticeBoardVO.setTitle("테스트 "+i);
			noticeBoardVO.setContent("테스트 내용입니다");
			java.sql.Date date = java.sql.Date.valueOf("2019-10-21");
			noticeBoardVO.setDate(date);
			noticeBoardVO.setHit(i);
			noticeBoardVO.setMemberId("DU");

			System.out.println(i+"번째 게시글 :"+noticeBoardVO.toString());
			noticeList.add(noticeBoardVO);
		}
		
		return noticeList;
	}
	
	@Override
	public NoticeBoardVO noticeDetail() throws Exception {
		// TODO Auto-generated method stub
		NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
		
		
		return noticeBoardVO;
	}

	@Override
	public NoticeBoardVO noticeEdit() throws Exception {
		// TODO Auto-generated method stub
		NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
		
		
		return noticeBoardVO;
	}

	@Override
	public NoticeBoardVO noticeReg() throws Exception {
		// TODO Auto-generated method stub
		NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
		
		
		return noticeBoardVO;
	}

}
