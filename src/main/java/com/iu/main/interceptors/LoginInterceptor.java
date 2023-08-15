package com.iu.main.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.main.member.MemberDTO;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	// qna의 모든 기능은 로그인한 사람만 가능
	// 단, list는 제외
	// 로그인 X일때, 로그인페이지로 이동
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		// 방법1. return forward 방식
		Object obj =request.getSession().getAttribute("member");
		
		if(obj != null) {
			return true;
		}else {
			//request.getRequestDispatcher("../../../member/login");
			request.setAttribute("message", "로그인 필요");
			request.setAttribute("url", "../../../member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			view.forward(request, response);
			return false;
		}
	}
}
