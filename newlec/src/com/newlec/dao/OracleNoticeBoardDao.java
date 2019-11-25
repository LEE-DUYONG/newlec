package com.newlec.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.newlec.config.SqlMapConfig;
import com.newlec.domain.NoticeBoardVO;
import com.newlec.domain.PageVO;	

public class OracleNoticeBoardDao implements NoticeBoardDao {
	
	static final Logger log = Logger.getLogger("");
	SqlSessionFactory sessionFactory = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public OracleNoticeBoardDao() {
		sqlsession = sessionFactory.openSession(true);
	}
	
	@Override
	public List<NoticeBoardVO> getBoardList() { // 게시글 전체 불러오기
		// TODO Auto-generated method stub
		log.info("[getBoardList] : 게시글 전체 불러오기");
		return sqlsession.selectList("getBoardList");
	}
	
	@Override
	public List<NoticeBoardVO> getBoardList(PageVO pageVO) { // 페이징 처리되어 해당 페이지의 게시글만 불러오기
		// TODO Auto-generated method stub
		log.info("[getBoardList] : " + pageVO);
		return sqlsession.selectList("getPagingBoardList", pageVO);
	}
	
	@Override
	public List<NoticeBoardVO> getBoardSearchList(PageVO pageVO) { // 페이징 처리되어 해당 페이지의 게시글만 불러오기
		// TODO Auto-generated method stub
		log.info("[getBoardSearchList] : " + pageVO);
		return sqlsession.selectList("getPagingSearchBoardList", pageVO);
	}
	
	@Override
	public int insertBoard(NoticeBoardVO noticeBoard) { // 새로운 게시글 작성
		// TODO Auto-generated method stub
		log.info("[insertBoard] : " + noticeBoard);
		return sqlsession.insert("insertBoard", noticeBoard);
	}
	
	@Override
	public NoticeBoardVO getBoardDetail(int num) { // 게시글 내용 불러오기
		// TODO Auto-generated method stub
		log.info("[getBoardDetail] - num : " + num);
		NoticeBoardVO boardDetail = sqlsession.selectOne("getBoardDetail", num);
		log.info("[getBoardDetail] - boardDetail : " + boardDetail);
		return boardDetail;
	}
	
	@Override
	public int getNewBoardNum(String memberId) { // 회원의 가장 최근 게시글 번호
		// TODO Auto-generated method stub
		log.info("[getNewBoardNum] : " + memberId);
		return sqlsession.selectOne("getNewBoardNum", memberId);
	}
	
	@Override
	public int updateBoard(NoticeBoardVO noticeBoard) { // 게시글 수정
		// TODO Auto-generated method stub
		log.info("[updateBoard] : " + noticeBoard);
		return sqlsession.update("updateBoard", noticeBoard);
	}
	
	@Override
	public int deleteBoard(int num) { // 게시글 삭제
		// TODO Auto-generated method stub
		log.info("[deleteBoard] : " + num);
		return sqlsession.delete("deleteBoard", num);
	}
	
	@Override
	public void upCountHits(int num) { // 게시글 조회수 +1
		// TODO Auto-generated method stub
		log.info("[upCountHits] : " + num);
		sqlsession.update("upCountHits", num);
	}
	
	@Override
	public int getCurRownum(int num) { // 게시글의 rownum 불러오기
		// TODO Auto-generated method stub
		log.info("[getCurRownum] : " + num);
		return sqlsession.selectOne("getCurRownum", num);
	}
	
	@Override
	public NoticeBoardVO getBoardTitle(int rownum) { // 게시글 제목 조회 (이전, 다음 게시물 제목 조회 시 사용)
		// TODO Auto-generated method stub
		log.info("[getBoardTitle] - rownum : " + rownum);
		NoticeBoardVO boardDetail = sqlsession.selectOne("getBoardTitle", rownum);
		log.info("[getBoardTitle] - boardDetail : " + boardDetail);
		return boardDetail;
	}
	
	@Override
	public int getBoardCount() { // 총 게시물 수
		// TODO Auto-generated method stub
		log.info("[getBoardCount] : 총 게시물 수 조회");
		return sqlsession.selectOne("getBoardCount");
	}
	
	@Override
	public int getBoardSearchCount(PageVO pageVO) { // 검색한 총 게시물 수
		// TODO Auto-generated method stub
		log.info("[getBoardSearchCount] - 검색한 SearchCategory : "+pageVO.getSearchCategory());
		log.info("[getBoardSearchCount] - 검색한 Keyword : "+pageVO.getSearchKeyword());
		int result = sqlsession.selectOne("getBoardSearchCount", pageVO);
		return result;
	}
	
}

