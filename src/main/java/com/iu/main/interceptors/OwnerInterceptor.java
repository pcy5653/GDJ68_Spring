package com.iu.main.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.main.board.BoardDTO;
import com.iu.main.member.MemberDTO;

public class OwnerInterceptor extends HandlerInterceptorAdapter {
	
	// 게시판
	// 수정 시, 로그인한 유저와 작성자가 일치
	
	
	
	// Controller -> DS
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		// method가 GET일 때만 실행.
		// POST라면 실행하지 않고 나간다.
		String method = request.getMethod();
		if(method.equals("POST")) {
			return;
		}
		
		
		// request에서 session을 꺼낸다 (id)
		MemberDTO memberDTO =(MemberDTO)request.getSession().getAttribute("member");
		
		// QNA update에서 model에 담아서 보내는데 여러개일 수도 있으니 Map<>으로 받기.
		// 작성자 꺼내기
		Map<String, Object> map = modelAndView.getModel();
		// 작성자의 내용은 boardDTO에 있어 타입을 boardDTO로 받는다.
		BoardDTO boardDTO = (BoardDTO)map.get("dto");
		
		// member의 ID와 board의 작성자 일치 확인
		if(!memberDTO.getId().equals(boardDTO.getName())) {
			// 소유자만 가능하단 경고창과 list 페이지 이동
			modelAndView.addObject("message", "작성자만 가능합니다.");
			modelAndView.addObject("url", "./list");      // notice, qna의 list로 돌아가기
			modelAndView.setViewName("commons/result");   // 경고창 출력
		}
	}
}
