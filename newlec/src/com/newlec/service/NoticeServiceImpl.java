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
		System.out.println("NoticeServiceImpl.noticeList");
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		// 게시판 리스트 전부
//		List<NoticeBoardVO> noticeList = noticeBoardDao.getBoardList();
		
		// 페이징 처리한 게시판 리스트
		List<NoticeBoardVO> noticeList = noticeBoardDao.getBoardList(pageVO);
		
//		System.out.println("noticeList - "+noticeList.toString());
		
		return noticeList;
	}

	@Override
	public PageVO noticePaging(int curPage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl.noticePaging");
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
		// 리턴타입 메소드명(받을 입력 파라미터)
		
		System.out.println("NoticeServiceImpl.noticeDetail");
		
		// contentNum를 이용해 게시글 불러오기
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		return noticeBoardDao.getBoardDetail(contentNum);
	}

	@Override
	public int noticeCurRownum(int contentNum) throws Exception {
		// TODO Auto-generated method stub
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		return noticeBoardDao.getCurRownum(contentNum);
	}

	@Override
	public NoticeBoardVO noticeNextTitle(int rownum) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl.noticeNextTitle");
		
		// contentNum의 rownum - 1로 다음 게시글 불러오기(contentNum으로 불러오면 삭제되었을 경우 불러오기 불가능)
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		return noticeBoardDao.getBoardTitle(rownum - 1);
	}

	@Override
	public NoticeBoardVO noticePreviousTitle(int rownum) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl.noticePreviousTitle");
		
		// contentNum의 rownum + 1로 이전 게시글 불러오기(contentNum으로 불러오면 삭제되었을 경우 불러오기 불가능)
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		return noticeBoardDao.getBoardTitle(rownum + 1);
	}

	@Override
	public void noticeHit(int contentNum) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl.noticeHit");
		
		// 조회수 +1
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		noticeBoardDao.upCountHits(contentNum);
		System.out.println("NoticeServiceImpl.noticeHit 종료");
	}
	
	@Override
	public int noticeDel(int contentNum) throws Exception {
		// TODO Auto-generated method stub
		
		// 나중에 유저이름체크도 추가

		System.out.println("noticeDel-contentNum:"+contentNum);
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		
		return noticeBoardDao.deleteBoard(contentNum);
	}
	
	@Override
	public int noticeEdit(NoticeBoardVO notice) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("noticeEdit");
		System.out.println("바뀐 내용 /// num = "+notice.getNum()+" title = "+notice.getTitle()+" content = "+notice.getContent());

		// notice의 정보를 DAO로 수정
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		int result = noticeBoardDao.updateBoard(notice);
		
		if(result == 0) {
			System.out.println("게시글 수정 실패");
		} else {
			System.out.println("게시글 수정 성공!");
		}
		
		return result;
	}

	@Override
	public int noticeRegProc(NoticeBoardVO notice) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("noticeRegProc");
		
		
		// 데이터 수동 작성
		notice.setMemberId("ow1l7");
		
		// Dao 호출
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		

		int result = noticeBoardDao.insertBoard(notice);
		
		if(result == 0) {
			System.out.println("게시글 작성 실패");
		} else {
			System.out.println("게시글 작성 성공!");
		}
		
		return result;
	}

	@Override
	public int newNoticeNum() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("curNoticeNum");
		
		// 임시 수동 memberId
		String memberId = "ow1l7";
		
		// 해당유저의 최신 등록한 글 번호 가져오기
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		return noticeBoardDao.getNewBoardNum(memberId);
	}

}
