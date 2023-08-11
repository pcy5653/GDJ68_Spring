package com.iu.main.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.mapping.ResultSetType;
// 총정리
// client > DS -> Controller -> Service -> DAO(Mapper가서 쿼리문 실행하여 DTO에 받아 다시 보내준다)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.comment.CommentDTO;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller // 해당 객체를 생성 (Controller 역할)
@RequestMapping("/bankbook/*")	// /bankbook/으로 들어온 모든 파일을 해당 class에서 처리하라
public class BankBookController {
	
	// controller(service 의존) -> service(DAO 의존) -> DAO -> DB
	
	// Service 의존
	@Autowired
	private BankBookService bankBookService;
	
	//--------BANKBOOK
	
	// List | Model타입 사용
	@RequestMapping(value="list", method=RequestMethod.GET)	// method=클래스명.메소드(상수=final)
	// pager에서 page번호, kind, search를 받는다
	public String getList(Pager pager, Model model) throws Exception {
		// @RequestParam(defaultValue = "1") Integer page -> 매개변수 : Null왔을 때 page의 기본값을 1로 넣어라.
		List<BankBookDTO> ar = bankBookService.getList(pager);
		// list.jsp의 속성명, object(List<BankBookDTO>로 받아온 내용) 
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
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
	
	
	//form
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String setAdd() throws Exception {
		System.out.println("add");
		return "bankbook/add";
		// JSP Form 경로
		// 리턴타입: void 일 경우 return X, RequestMapping 경로를 따라간다.
		// 아래 참조	
	}
//	@RequestMapping(value="add", method=RequestMethod.GET)
//	public void setAdd() throws Exception {
//
//	}
	
	// DB insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	// MultipartFile [] photos = 파라미터명과 동일하게 작성
	public String setAdd(BankBookDTO bankBookDTO, MultipartFile [] photos, HttpSession session) throws Exception{
		int result = bankBookService.setAdd(bankBookDTO, photos, session);
		
		// Add method (GET -> POST)
		// GET(method)일 때는 정상 경로이지만
		// POST는 Add로 들어가는 method가 맞지 않기에 redirect로 경로 재설정
		return "redirect:./list";
	}
	
	
	// Form(update)
	// void면 return 시 해당 jsp경로 찾아감.
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void setUpdate(BankBookDTO bankBookDTO, Model model) throws Exception {
		bankBookDTO=bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	// DB Update
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception {
		int restlt = bankBookService.setUpdate(bankBookDTO);
//		return "redirect:./list";
		return "redirect:./detail?bookNum="+bankBookDTO.getBookNum();
	}
	
	
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String setDelete(Long bookNum) throws Exception{
		int result = bankBookService.setDelete(bookNum);
	
		return "redirect:./list";
	}
	
	
	
	//--------COMMENT (bankbook > detail.jsp > commentList table 쪽)
	@GetMapping("commentList")
	public void getCommentList(CommentDTO commentDTO, Pager pager, Model model)throws Exception{
		pager.setPerPage(2L);
		List<CommentDTO> ar = bankBookService.getCommentList(pager, commentDTO);
		model.addAttribute("commentList", ar);
	}
	@PostMapping("commentAdd")
	public String setCommentAdd(CommentDTO commentDTO, HttpSession session, Model model)throws Exception{
		// id를 memberDTO에 받아 comment id에 넣고 결과갑을 ajaxResult.jsp로 보낸다.
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		commentDTO.setId(memberDTO.getId());
		int result = bankBookService.setCommentAdd(commentDTO);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
		
	}

}
