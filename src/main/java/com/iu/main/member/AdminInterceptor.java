package com.iu.main.member;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// Object 타입이기에 MemberDTO 타입으로 형변환
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		List<RoleDTO> roles =memberDTO.getRoles();
		
		// List에서 하나 뽑으면 RoleDTO 타입
		for (RoleDTO roleDTO:roles) {
			// 1. ADMIN이면 통과
			if(roleDTO.getRoleName().equals("ADMIN")) {
				return true;
			}
		}
		
		// 2. ADMIN이 아니라면 
		request.setAttribute("message", "권한이 불충분합니다.");
		request.setAttribute("url", "/");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		try {
			view.forward(request, response);			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
}
