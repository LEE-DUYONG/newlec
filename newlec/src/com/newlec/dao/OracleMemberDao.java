package com.newlec.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.newlec.config.SqlMapConfig;
import com.newlec.domain.MemberVO;

public class OracleMemberDao implements MemberDao {	
	
	static final Logger log = Logger.getLogger("");
	SqlSessionFactory sessionFactory = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public OracleMemberDao() {
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
	public int insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		
		log.info("★멤버★ : " + member);
		
		return sqlsession.insert("insertNewMember", member);
	}

	@Override
	public int findMemberId(String id) throws Exception {
		// TODO Auto-generated method stub
		
		int result = sqlsession.selectOne("selectUserId", id);
		System.out.println("result:"+result);
		return result;
	}

	@Override
	public MemberVO getMemberLoginInfo(MemberVO member) {
		// TODO Auto-generated method stub
		member = sqlsession.selectOne("getMemberLoginInfo", member);
		log.info(member);
		
		return member;
	}
	
}
