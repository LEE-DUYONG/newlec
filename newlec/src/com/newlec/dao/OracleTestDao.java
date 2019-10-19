package com.newlec.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.newlec.config.SqlMapConfig;

public class OracleTestDao implements TestDao {

	static final Logger log = Logger.getLogger("");
	SqlSessionFactory sessionFactory = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession; 
	
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
}