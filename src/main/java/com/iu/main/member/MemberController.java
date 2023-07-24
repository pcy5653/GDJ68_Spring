package com.iu.main.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	// 로그인
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String getlogin() throws Exception {
		return "member/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String getlogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		memberDTO = memberService.getLogin(memberDTO);
		
		if(memberDTO != null) {
			// session은 tomcat 실행 시 생성 -> session안에 로그인 정보를 담고 있다.
			// 해당 if문은 로그인 했을 시(값이 null이 아니다= not empty | header.jsp), session에 member(키),memberDTO(값)이 있다. 라는 구문
			session.setAttribute("member", memberDTO);
		}
		
		// 리턴 : index로 가라. | / or ../ (root 주소)
		return "redirect:../";
	}
	
	
	
	// 로그아웃
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String getlogout(HttpSession session) throws Exception{
		// 1. member 키로 값에 null
		// 2. session 자체 삭제 ===> 선택
		// session.invalidate(); : session의 시간을 0으로 만들기
		session.invalidate();

		// 리턴 : index로 가라. | / or ../ (root 주소)
		return "redirect:/";
	}
	
	
	// 마이페이지
	@RequestMapping(value="mypage", method = RequestMethod.GET)
	public void getMypage() throws Exception {
		// session에 모든 정보가 있다.
		//return "member/mypage";
	}
	
	
	
	// update
	@RequestMapping(value="memberUpdate", method=RequestMethod.GET)
	public void setMemberUpdate() throws Exception{
		//리턴없이 바로 value의 이름으로 가도록
	}
	
//	@RequestMapping(value="join", method=RequestMethod.GET)
//	public String join() throws Exception {
//		System.out.println("join");
//		return "member/join";
//	}
}
