package com.iu.main.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class InterceptorTest1 extends HandlerInterceptorAdapter {
	
	// DS -> Controller 사이 존재
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		
		// return : true 면 Controller로 계속 진행.
		// return : false면 거절 (redirect)
		System.out.println("Controller 진입 전");
		
		// 방법 1. return forward 방식
		request.setAttribute("name", response);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/../..");
		view.forward(request, response);
		
		// 방법 2. return redirect 방식
		// response.sendRedirect(null); 
		return true;
	}
	
	// Controller -> DS 사이 존재
	// 매개변수 MV는 Controller에서 DS로 가기 때문에 갖는다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Controller에서 DS 가기 전");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	// JSP -> DS 사이 존재
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("JSP를 랜더링(작성) 한 후");
		super.afterCompletion(request, response, handler, ex);
	}
}
