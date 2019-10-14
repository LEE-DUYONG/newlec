package com.newlec.config;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlec.controller.Controller;
import com.newlec.controller.TestController;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		System.out.println("requestURI : " + requestURI);
		
		String ctxPath = request.getContextPath();
		System.out.println("ctxPath : " + ctxPath);
		
		String returnURL = null;
		
		if(requestURI.equals(ctxPath + "/test")) {
			System.out.println("test");
			Controller testController = new TestController();
			try {
				returnURL = (String) testController.execute(request, response);
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
