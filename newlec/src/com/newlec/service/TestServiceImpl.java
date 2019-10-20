package com.newlec.service;

import com.newlec.dao.OracleTestDao;
import com.newlec.dao.TestDao;
import com.newlec.domain.MemberVO;

public class TestServiceImpl implements TestService {

	@Override
	public String retrieveDate() throws Exception {
		// TODO Auto-generated method stub
		
		TestDao testDao = new OracleTestDao();
		String date = testDao.retrieveDate();
		return date;
	}

	@Override
	public void getListMember() throws Exception {
		// TODO Auto-generated method stub
		new OracleTestDao().getMemberList();
	}

	@Override
	public void registerMember(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		new OracleTestDao().insertMember(member);
		
	}
}
