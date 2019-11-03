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
		
		return noticeList;
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
	public NoticeBoardVO noticeNextTitle(int contentNum) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl.noticeNextTitle");
		
		// contentNum의 rownum + 1로 다음 게시글 불러오기(contentNum으로 불러오면 삭제되었을 경우 불러오기 불가능)
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		
		//return noticeBoardDao.            (contentNum);
		return null;
	}

	@Override
	public NoticeBoardVO noticePreviousTitle(int contentNum) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl.noticePreviousTitle");
		
		// contentNum의 rownum - 1로 이전 게시글 불러오기(contentNum으로 불러오면 삭제되었을 경우 불러오기 불가능)
		NoticeBoardDao noticeBoardDao = new OracleNoticeBoardDao();
		
		
		//return noticeBoardDao.            (contentNum);
		return null;
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
