package com.newlec.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.newlec.config.SqlMapConfig;
import com.newlec.domain.MemberVO;

public class OracleTestDao implements TestDao {

	static final Logger log = Logger.getLogger("");
	SqlSessionFactory sessionFactory = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession; 
	
	// 깃허브 테스트
	
	public OracleTestDao() {
		sqlsession = sessionFactory.openSession(true); // sqlSession 얻어오기
	}
	
	@Override
	public String retrieveDate() throws Exception {
		// TODO Auto-generated method stub

		String result = sqlsession.selectOne("selectDate");
		log.info(result);
		return result;
	}

	@Override
	public void getMemberList() {
		// TODO Auto-generated method stub
		List<MemberVO> memberVO = sqlsession.selectList("getListMember");
		log.info(memberVO);
	}

	@Override
	public void insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		
		log.info("★멤버★ : " + member);
		
		sqlsession.insert("insertMember", member);
	}
	
}