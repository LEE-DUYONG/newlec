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
		// sqlSession 얻어오기
		sqlsession = sessionFactory.openSession(true);
	}
	
	@Override
	public String retrieveDate() throws Exception { // 날짜조회
		// TODO Auto-generated method stub
		String date = sqlsession.selectOne("selectDate");
		log.info("[retrieveDate] : "+date);
		return date;
	}
	
	@Override
	public List<MemberVO> getMemberList() { // 회원리스트 조회
		// TODO Auto-generated method stub
		List<MemberVO> memberVO = sqlsession.selectList("getListMember");
		log.info("[getMemberList] : "+memberVO);
		return memberVO;
	}
	
	@Override
	public int insertMember(MemberVO member) { // 회원가입
		// TODO Auto-generated method stub
		log.info("[insertMember] : " + member);
		return sqlsession.insert("insertNewMember", member);
	}
	
	@Override
	public int findMemberId(String id) throws Exception { // 아이디 존재유무 확인 0(없음) or 1(있음)
		// TODO Auto-generated method stub
		log.info("[findMemberId] - id : " + id);
		int result = sqlsession.selectOne("selectUserId", id);
		log.info("[findMemberId] - result : " + result);
		return result;
	}
	
	@Override
	public MemberVO getMemberLoginInfo(MemberVO member) { // 로그인한 회원의 ID , ID(USERNAME)
		// TODO Auto-generated method stub
		log.info("[getMemberLoginInfo] - member : " + member);
		member = sqlsession.selectOne("getMemberLoginInfo", member);
		log.info("[getMemberLoginInfo] - result : " + member);
		return member;
	}
	
}
