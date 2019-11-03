package com.newlec.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.newlec.config.SqlMapConfig;
import com.newlec.domain.NoticeBoardVO;	

public class OracleNoticeBoardDao implements NoticeBoardDao {
	
	static final Logger log = Logger.getLogger("");							
	SqlSessionFactory sessionFactory = SqlMapConfig.getSqlMapInstance();							
	SqlSession sqlsession;
	
	public OracleNoticeBoardDao() {							
		sqlsession = sessionFactory.openSession(true);
	}
	
	@Override
	public List<NoticeBoardVO> getBoardList() {
		// TODO Auto-generated method stub
		
		return sqlsession.selectList("getBoardList");
		
	}
	@Override
	public int insertBoard(NoticeBoardVO noticeBoard) {
		// TODO Auto-generated method stub
		
		log.info("[noticeBoard] : " + noticeBoard);
		
		return sqlsession.insert("insertBoard", noticeBoard);
	}

	@Override
	public NoticeBoardVO getBoardDetail(int num) {
		// TODO Auto-generated method stub
		NoticeBoardVO boardDetail = sqlsession.selectOne("getBoardDetail", num);
		
		log.info("[boardDetail] : " + boardDetail);
		
		return boardDetail;
	}

	@Override
	public int getNewBoardNum(String memberId) {
		// TODO Auto-generated method stub
		
		return sqlsession.selectOne("getNewBoardNum", memberId);
	}

	@Override
	public int updateBoard(NoticeBoardVO noticeBoard) {
		// TODO Auto-generated method stub
		
		log.info("[updateBoard] : " + noticeBoard);
		
		return sqlsession.update("updateBoard", noticeBoard);
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		log.info("[deleteBoard] : " + num);
		System.out.println("deleteBoard-num:"+num);
		return sqlsession.delete("deleteBoard", num);
	}
						
}

