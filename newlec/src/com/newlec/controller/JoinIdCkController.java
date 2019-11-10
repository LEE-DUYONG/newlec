package com.newlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.newlec.service.UserServiceImpl;

public class JoinIdCkController  implements Controller {

	@SuppressWarnings("unchecked")
	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String uid = (String) request.getParameter("uid");
		System.out.println("uid:"+uid);
		
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		String result = userServiceImpl.joinUserIdCk(uid);

		JSONObject jobj = new JSONObject();
		jobj.put("result",result);
		response.getWriter().write(jobj.toString());
		
		
		return "dispatcher:/joinus/join.jsp";
	}
}
