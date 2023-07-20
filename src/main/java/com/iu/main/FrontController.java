package com.iu.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/*")
@Controller
public class FrontController {
	
	//1. home 메서드명, root(/) 주소가 왔을 때 실행, index.jsp
	//2. BankBookController
	//3. MemberController, GET
	// 주소 .do 삭제 (ex> /member/login)
	@RequestMapping(value="")
	public String Home() throws Exception {
		System.out.println("index");
		
		return "index";
	}
}
