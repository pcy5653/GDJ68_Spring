package com.iu.main.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter_1
 */
public class Filter_1 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter_1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	// 요청 발생 시 DS 가기전에 거침, 요청*응답이 나가기 전에 무조건 거치고 나는 부분
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 요청 발생 시 실행 (chain 위 작성)
		System.out.println("filter1 request");
		// 로그인 여부 (session의 member) -> HttpServletRequest타입
		// ServletRequest > HttpServletRequest
		HttpSession session = ((HttpServletRequest)request).getSession();
		Object obj = session.getAttribute("member");   // id null 확인만 하기
		
		if(obj != null) {
			chain.doFilter(request, response);     // null이 아니라면 DS으로 이동.			
		}else {
			// Servlet 방식의 forward와 redirect
			// forward 
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/login");
//			view.forward(request, response);
			
			// redirect
			((HttpServletResponse)response).sendRedirect("../member/login");
					
		}
 		
		
		// 응답 발생 시 실행 (chain 아래 작성)
		System.out.println("filter1 responce");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
