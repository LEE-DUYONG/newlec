package com.newlec.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.newlec.config.SqlMapConfig;

public class OracleTestDao implements TestDao {

	
	SqlSessionFactory sessionFactory = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession; 
	
	public OracleTestDao() {
		sqlsession = sessionFactory.openSession(true); //true 로 할시 자동 commit
	}
	
	@Override
	public String retrieveDate() throws Exception {
		// TODO Auto-generated method stub
		String result = sqlsession.selectOne("selectDate");
		System.out.println("result : " + result);
		return result;
	}
}