package com.iu.main.bankBook;

import java.util.List;

// 총정리
// client > DS -> Controller -> Service -> DAO(Mapper가서 쿼리문 실행하여 DTO에 받아 다시 보내준다)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // 해당 객체를 생성 (Controller 역할)
@RequestMapping("/bankbook/*")	// /bankbook/으로 들어온 모든 파일을 해당 class에서 처리하라
public class BankBookController {
	
	// controller(service 의존) -> service(DAO 의존) -> DAO -> DB
	
	// Service 의존
	@Autowired
	private BankBookService bankBookService;
	
	
	// List | Model타입 사용
	@RequestMapping(value="list", method=RequestMethod.GET)	// method=클래스명.메소드(상수=final)
	public String getList(Model model) throws Exception {
		List<BankBookDTO> ar = bankBookService.getList();
		// list.jsp의 속성명, object(List<BankBookDTO>로 받아온 내용) 
		model.addAttribute("list", ar);
		
		// return 값으로 model로 내용이 작성된 list.jsp 경로를 보내준다.
		return "bankbook/list";
	}
	
	// detail | ModelAndView타입 사용(Controller > DS 리턴하는 매개변수사용)
	@RequestMapping(value="detail")
	public ModelAndView getDetail(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookName());
		// 해당 경로(View = detail.jsp)로 가서 (Model)dto 속성명의 bankBookDTO의 내용 보기
		// src >> spring > appServlet > servlet-context.xml의 prefix와 suffix 붕여짐
		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);
		
		return mv;
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
