package com.newlec.config;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.newlec.controller.Controller;
import com.newlec.controller.IndexController;
import com.newlec.controller.JoinController;
import com.newlec.controller.LoginController;
import com.newlec.controller.NoticeDelController;
import com.newlec.controller.NoticeDetailController;
import com.newlec.controller.NoticeEditController;
import com.newlec.controller.NoticeEditProcController;
import com.newlec.controller.NoticeListController;
import com.newlec.controller.NoticeRegController;
import com.newlec.controller.NoticeRegProcController;
import com.newlec.controller.TestController;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.yjc")
public class DispatcherServlet extends HttpServlet {
	static final Logger log = Logger.getLogger("");
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String requestURI = request.getRequestURI();
		log.info("requestURI : " + requestURI);
		
		String ctxPath = request.getContextPath();
		log.info("ctxPath : " + ctxPath);
		
		String returnURL = null;
		
		if(requestURI.equals(ctxPath + "/test.yjc")) { // 테스트페이지
			log.info("test");
			Controller testController = new TestController();
			
			try {
				returnURL = (String) testController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/index.yjc")) { // 메인페이지
			System.out.println("index");
			Controller indexController = new IndexController();
			try {
				returnURL = (String) indexController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/join.yjc")) { // 회원가입
			System.out.println("join");
			Controller joinController = new JoinController();
			try {
				returnURL = (String) joinController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/login.yjc")) { // 로그인
			System.out.println("login");
			Controller loginController = new LoginController();
			try {
				returnURL = (String) loginController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/notice.yjc")) { // 게시판 메인
			System.out.println("noticeList");
			Controller noticeListController = new NoticeListController();
			try {
				returnURL = (String) noticeListController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/noticeDetail.yjc")) { // 게시글 보기
			System.out.println("noticeDetail");
			Controller noticeDetailController = new NoticeDetailController();
			try {
				returnURL = (String) noticeDetailController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/noticeDel.yjc")) { // 게시글 삭제 후 리스트
			System.out.println("noticeDel");
			Controller noticeDelController = new NoticeDelController();
			try {
				returnURL = (String) noticeDelController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/noticeEdit.yjc")) { // 게시글 보기 후 수정
			System.out.println("noticeEdit");
			Controller noticeEditController = new NoticeEditController();
			try {
				returnURL = (String) noticeEditController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/noticeEditProc.yjc")) { // 게시글 수정 실행
			System.out.println("noticeEditProc");
			Controller noticeEditProcController = new NoticeEditProcController();
			try {
				returnURL = (String) noticeEditProcController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/noticeReg.yjc")) { // 게시글 작성 페이지
			System.out.println("noticeReg");
			Controller noticeRegController = new NoticeRegController();
			try {
				returnURL = (String) noticeRegController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(requestURI.equals(ctxPath + "/noticeRegProc.yjc")) { // 게시글 작성 실행
			System.out.println("noticeRegProc");
			Controller noticeRegProcController = new NoticeRegProcController();
			try {
				returnURL = (String) noticeRegProcController.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*
		 * if(requestURI.equals(ctxPath + "/customer/notice.jsp")){ }else
		 * if(requestURI.equals(ctxPath+"/customer/noticeDetail.jsp")){ }else
		 * if(requestURI.equals(ctxPath+"/customer/noticeReg.jsp")){ }else
		 * if(requestURI.equals(ctxPath+"/customer/noticeEdit.jsp")){ }else
		 * if(requestURI.equals(ctxPath+"/customer/noticeDel.jsp")){ }
		 */

		// Move to View Page Process
		if(returnURL != null && !"".equals(returnURL)){
			StringTokenizer urlForToken = new StringTokenizer(returnURL,":");
			String url = urlForToken.nextToken();
			System.out.println(url);
			
			if("dispatcher".equals(url)){
				request.getRequestDispatcher(urlForToken.nextToken()).forward(request, response);
			}else if("sendRedirect".equals(url)){
				response.sendRedirect(urlForToken.nextToken());
			}
		}
		
	}
}
