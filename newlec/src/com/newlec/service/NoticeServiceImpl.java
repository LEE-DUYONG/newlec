package com.newlec.service;

import java.util.List;

import com.newlec.dao.NoticeBoardDao;
import com.newlec.dao.OracleNoticeBoardDao;
import com.newlec.domain.NoticeBoardVO;

public class NoticeServiceImpl implements NoticeService {
	
	@Override
	public List<NoticeBoardVO> noticeList(int curPage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl.noticeList");
		
		// curPage 현재페이지
		int pageRow = 10; // 한 페이지당 출력하는 게시글 수
		int startRow = 1; // 해당페이지의 시작 게시물
		int endRow = 1; // 해당페이지의 종료 게시물
		int noticeTotalCount = 1; // 총게시글
		
		// DAO와 연결해 게시글 전체 수 불러오기
		/* AbcDAO CccDAO = new AbcDAO();
		 * noticeTotalCount = CccDAO.totalRow();
		 */
		
		// 총게시글 임시 할당
		noticeTotalCount = 15;
		
		startRow = (curPage * pageRow) - (pageRow - 1);
		
		if(noticeTotalCount / pageRow <= curPage * pageRow) { // 마지막페이지의 글이 10개(pageRow)보다 작거나 같을 경우
			endRow = noticeTotalCount;
		} else {
			endRow = startRow + (pageRow - 1);
		}
		
		
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		
		
		List<NoticeBoardVO> noticeList = noticeBoardDao.getBoardList();
		
		// startRow와 endRow를 이용해 게시판 일부 불러오기
		/* AbcDAO abcDAO = new AbcDAO();
		 * 
		 * noticeList = abcDAO.noticeList(startRow, endRow);
		 * 
		*/
		
		// 수동 데이터 입력
		/*
		 * for (int i = 1; i <= 15; i++) { NoticeBoardVO noticeBoardVO = new
		 * NoticeBoardVO(); noticeBoardVO.setNum(i); noticeBoardVO.setTitle("테스트 "+i);
		 * noticeBoardVO.setContent("테스트 내용입니다"); java.sql.Date date =
		 * java.sql.Date.valueOf("2019-10-21"); noticeBoardVO.setCreatedDate(date);
		 * noticeBoardVO.setHit(i); noticeBoardVO.setMemberId("DU");
		 * 
		 * System.out.println(i+"번째 게시글 :"+noticeBoardVO.toString());
		 * noticeList.add(noticeBoardVO); }
		 */
		
		return noticeList;
	}
	
	@Override
	public NoticeBoardVO noticeDetail(int contentNum) throws Exception {
		// TODO Auto-generated method stub
		// 리턴타입 메소드명(받을 입력 파라미터)
		
		System.out.println("NoticeServiceImpl.noticeDetail");
		NoticeBoardVO noticeBoardVO = new NoticeBoardVO();
		
		// contentNum를 이용해 게시글 불러오기
		/* AbcDAO abcDAO = new AbcDAO();
		 * 
		 * contentNum 변수는 보고싶은 게시글 번호
		 * noticeBoardVO = abcDAO.noticeContent(contentNum);
		 * 
		*/
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		NoticeBoardVO boardDetail = noticeBoardDao.getBoardDetail(contentNum);
		
		// 수동데이터 입력
		/*
		 * noticeBoardVO.setNum(1); noticeBoardVO.setTitle("임의 데이터 타이틀");
		 * noticeBoardVO.setMemberId("DU"); java.sql.Date date =
		 * java.sql.Date.valueOf("2019-10-26"); noticeBoardVO.setCreatedDate(date);
		 * noticeBoardVO.setHit(10); noticeBoardVO.setContent("임의 데이터 내용입니다.");
		 */
//		noticeBoardVO.setPreviousTitle("이전 게시글 제목");
//		noticeBoardVO.setPreviousTitle(null);
//		noticeBoardVO.setNextTitle("다음 게시글 제목");
//		noticeBoardVO.setNextTitle(null);
//		System.out.println(noticeBoardVO.toString());
		
		return boardDetail;
	}

	@Override
	public int noticeDel(int contentNum) throws Exception {
		// TODO Auto-generated method stub
		
		// 나중에 유저이름체크도 추가

		int result = 0;
		//contentNum 게시글 번호를 이용해 게시글 삭제 DAO
		
		if(result == 0) {
			System.out.println("게시글 삭제 실패");
		} else {
			System.out.println("게시글 삭제 성공!");
		}
		
		
		return result;
	}
	
	@Override
	public int noticeEdit(NoticeBoardVO notice) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("noticeEdit");
		System.out.println("바뀐 내용 /// num = "+notice.getNum()+" title = "+notice.getTitle()+" content = "+notice.getContent());
		
		int result = 0;
		
		if(result == 0) {
			System.out.println("게시글 수정 실패");
		} else {
			System.out.println("게시글 수정 성공!");
		}
		
		// notice의 정보를 DAO로 수정
		
		return 0;
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

}
