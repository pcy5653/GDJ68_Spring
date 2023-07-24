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
	// update (POST, 수정된 내용)
	@RequestMapping(value="memberUpdate",method = RequestMethod.POST)
	public String setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception{
		// 1-1. 매개변수 : memberDTO로 결과값(정수, 0~1)받기  
		// 1-2. 매개변수 : session으로 DTO가져와 DTO안에 ID갖고오기, ID는 수정하지 않기 때문에 기존session의 정보가 필요
		
		MemberDTO sessionMember = (MemberDTO)session.getAttribute("member");
		// 1. session의 login POST에서 setAttribute의 키=member이기에 꺼내올 때 getAttribute("member")!
		// 2. memberDTO타입이지만 session에서 넣을 때는 모든(Object)타입이기에 "형변환"하기
		
		memberDTO.setId(sessionMember.getId());
		// 1. memberDTO에 가져온 sessionMember의 ID를 넣는다.
		
		int result=memberService.setMemberUpdate(memberDTO);
		// login한 사람의 회원수정이기에 session안에(session > DTO > ID) ID의 내용이 있다
		
		if(result>0) {
			session.setAttribute("member", memberDTO);
			// 1. update가 됐을 시, 해당 내용을 session안에 넣는다.
		}
		return "redirect:./mypage";
	}
	
//	@RequestMapping(value="join", method=RequestMethod.GET)
//	public String join() throws Exception {
//		System.out.println("join");
//		return "member/join";
//	}
}
