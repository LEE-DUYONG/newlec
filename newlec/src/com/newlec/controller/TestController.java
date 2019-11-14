package com.newlec.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.newlec.domain.MemberVO;
import com.newlec.service.TestService;
import com.newlec.service.TestServiceImpl;

public class TestController implements Controller {
	
	static final Logger log = Logger.getLogger("");
	
	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		log.info("로그4J 테스트합니다.");
		
		TestService testService = new TestServiceImpl();
		
		// 회원 리스트 얻어오기 리스트 테스트
		testService.getListMember();	
		
		// 임시 회원 아이디 등록
		MemberVO member = new MemberVO();
		String tempId = createId();
		
		member.setId(tempId);
		member.setPassword(tempId);
		member.setUserName("고인돌");
		member.setSex('F');	
		member.setPhone_number("010-1111-2222");
		member.setEmail(tempId + "@" + "yjc.co.jp");
		
		log.info("member : " + member);
		testService.registerMember(member);
		
		// 날짜 얻어오기 테스트
		String curDate = testService.retrieveDate();
		request.setAttribute("curDate", curDate);
		
		return "dispatcher:/WEB-INF/test.jsp";
		
		// 디스패쳐 : dispatcher:/customer/notice.jsp
		// 리다이렉트 : sendRedirect:notice.html
	}
	
	// 임시 id 생성
	private String createId() {
		Random rnd = new Random();
		String id = "";
		for(int i = 0; i < 5; i++){
		    if(rnd.nextBoolean()){
		        id = id + (char)((int)(rnd.nextInt(26))+97);
		    }else{
		        id = id + (rnd.nextInt(10));
		    }
		}
		return id;	
	}
	
}