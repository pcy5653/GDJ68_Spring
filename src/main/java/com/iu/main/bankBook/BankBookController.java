package com.iu.main.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 해당 객체를 생성 (Controller 역할)
@RequestMapping("/bankbook/*")	// /bankbook/으로 들어온 모든 파일을 해당 class에서 처리하라
public class BankBookController {
	
	// controller(service 의존) -> service(DAO 의존) -> DAO -> DB
	
	// Service 의존
	@Autowired
	private BankBookService bankBookService;
	
	
	@RequestMapping(value="list", method=RequestMethod.GET)	// method=클래스명.메소드(상수=final)
	public String getList() throws Exception {
		System.out.println("list");
		bankBookService.service();
		
		// src >> spring > appServlet > servlet-context.xml
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail")
	public String getDetail() throws Exception {
		System.out.println("Detail");
		return "bankbook/detail";
	}
	
	@RequestMapping(value="add")
	public String add() throws Exception {
		System.out.println("add");
		return "bankbook/add";
	}
	
	@RequestMapping(value="update")
	public String update() throws Exception {
		System.out.println("update");
		return "bankbook/update";
	}
	

}
