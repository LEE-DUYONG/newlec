package com.newlec.service;

import com.newlec.dao.OracleTestDao;
import com.newlec.dao.TestDao;

public class TestServiceImpl implements TestService {

	@Override
	public String retrieveDate() throws Exception {
		// TODO Auto-generated method stub
		
		TestDao testDao = new OracleTestDao();
		String date = testDao.retrieveDate();
		
		return date;
	}
}
