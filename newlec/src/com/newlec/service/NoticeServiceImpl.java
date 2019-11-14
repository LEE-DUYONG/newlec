package com.newlec.service;

import java.util.List;

import com.newlec.dao.NoticeBoardDao;
import com.newlec.dao.OracleNoticeBoardDao;
import com.newlec.domain.NoticeBoardVO;
import com.newlec.domain.PageVO;

public class NoticeServiceImpl implements NoticeService {
	
	@Override
	public List<NoticeBoardVO> noticeList(PageVO pageVO) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("noticeList");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		// 게시판 리스트 전부
//		List<NoticeBoardVO> noticeList = noticeBoardDao.getBoardList();
		
		// 페이징 처리한 게시판 리스트
		List<NoticeBoardVO> noticeList = noticeBoardDao.getBoardList(pageVO);
		
		return noticeList;
	}
	
	@Override
	public PageVO noticePaging(int curPage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("noticePaging");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		PageVO pageVO = new PageVO();
		
		// curPage 현재페이지
		int pageRow = 10; // 한 페이지당 출력하는 게시글 수
		int startRow = 1; // 해당페이지의 시작 게시물
		int endRow = 1; // 해당페이지의 종료 게시물
		int noticeTotalRow = noticeBoardDao.getBoardCount(); // 게시글 전체 수
		int noticeTotalPage = (int)Math.ceil((noticeTotalRow/(double)pageRow)); // 게시글 페이지 수
		System.out.println("페이지수 noticeTotalRow/pageRow:"+noticeTotalRow+"/"+pageRow+"="+noticeTotalRow/pageRow);
		int startPage = 1; // 해당페이지의 시작 페이지 번호
		int lastPage = 1; // 해당페이지의 마지막 페이지 번호
		
		startRow = (curPage * pageRow) - (pageRow - 1); // (1 * 10) - (10 - 1) = 10 - 9 = 1
		                                                // (2 * 10) - (10 - 1) = 20 - 9 = 11
		if(curPage == noticeTotalPage) { // 마지막페이지일 경우
			endRow = noticeTotalRow;
		} else {
			endRow = startRow + (pageRow - 1); // 1 + (10 - 1) = 1 + 9 = 10
			                                   // 11 + (10 - 1) = 11 + 9 = 20
		}
		
		if(curPage <= 3) {
			startPage = 1;
		} else {
			startPage = curPage-2;
		}
		
		if((noticeTotalPage - curPage) <= 2) {
			lastPage = noticeTotalPage;
		} else {
			lastPage = startPage+4;
		}
		
		pageVO.setStartRow(startRow);
		pageVO.setEndRow(endRow);
		pageVO.setTotalPage(noticeTotalPage);
		pageVO.setCurPage(curPage);
		pageVO.setStartPage(startPage);
		pageVO.setLastPage(lastPage);
		
		return pageVO;
	}
	
	@Override
	public NoticeBoardVO noticeDetail(int contentNum) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("noticeDetail");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		// contentNum를 이용해 게시글 불러오기
		return noticeBoardDao.getBoardDetail(contentNum);
	}
	
	@Override
	public int noticeCurRownum(int contentNum) throws Exception { // 현재 게시글의 rownum 불러오기
		// TODO Auto-generated method stub
		System.out.println("noticeCurRownum");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		return noticeBoardDao.getCurRownum(contentNum);
	}
	
	@Override
	public NoticeBoardVO noticeNextTitle(int rownum) throws Exception { // rownum의 다음 게시글 제목 불러오기
		// TODO Auto-generated method stub
		System.out.println("noticeNextTitle");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		return noticeBoardDao.getBoardTitle(rownum - 1);
	}
	
	@Override
	public NoticeBoardVO noticePreviousTitle(int rownum) throws Exception { // rownum의 이전 게시글 제목 불러오기
		// TODO Auto-generated method stub
		System.out.println("noticePreviousTitle");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		return noticeBoardDao.getBoardTitle(rownum + 1);
	}
	
	@Override
	public void noticeHit(int contentNum) throws Exception {// 조회수 +1
		// TODO Auto-generated method stub
		System.out.println("noticeHit");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		noticeBoardDao.upCountHits(contentNum);
	}
	
	@Override
	public int noticeDel(int contentNum) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("noticeDel");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		return noticeBoardDao.deleteBoard(contentNum);
	}
	
	@Override
	public int noticeEdit(NoticeBoardVO notice) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("noticeEdit");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		int result = noticeBoardDao.updateBoard(notice);
		return result;
	}
	
	@Override
	public int noticeRegProc(NoticeBoardVO notice, String userId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("noticeRegProc");
		notice.setMemberId(userId);
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		int result = noticeBoardDao.insertBoard(notice);
		return result;
	}
	
	@Override
	public int newNoticeNum(String userid) throws Exception { // 해당유저의 최신 등록한 글 번호 가져오기
		// TODO Auto-generated method stub
		System.out.println("curNoticeNum");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		return noticeBoardDao.getNewBoardNum(userid);
	}
	
}
