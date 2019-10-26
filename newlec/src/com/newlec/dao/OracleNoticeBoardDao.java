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
	public void insertBoard(NoticeBoardVO noticeBoard) {
		// TODO Auto-generated method stub
		
	}

					
								
}

