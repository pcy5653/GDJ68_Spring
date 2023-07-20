package com.iu.main.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join() throws Exception {
		System.out.println("join");
		return "member/join";
	}
	
	@RequestMapping(value="login")
	public String login() throws Exception {
		System.out.println("login");
		return "member/login";
	}
	
	@RequestMapping(value="mypage")
	public String mypage() {
		System.out.println("mypage");
		return "member/mypage";
	}
}
