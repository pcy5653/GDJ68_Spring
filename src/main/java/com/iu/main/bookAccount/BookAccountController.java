package com.iu.main.bookAccount;

import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/bookAccount/*")
public class BookAccountController {
	
	@Autowired
	private BookAccountService bookAccountService;
	
	
	
	// List => mypage에 나타내기
	
	@RequestMapping(value = "list")
	public ModelAndView getList(HttpSession session, Pager pager)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<BookAccountDTO> ar = bookAccountService.getList(memberDTO, pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("bookAccount/list");
		
		return mv;
		}
	
	
	// >> Session에서 ID 꺼내오기
	
	// Add : bookNum, password를 받아오기.
	// 파라미터로 bookNum을 받아오니(1) password를 입력하도록(2)!
	@GetMapping(value = "add")
	public void setAdd(BookAccountDTO bookAccountDTO, Model model)throws Exception{
		model.addAttribute("dto", bookAccountDTO);
	}
	@PostMapping(value = "add")
	public String setAdd(BookAccountDTO bookAccountDTO, HttpSession session, Model model)throws Exception{
		// Session의 ID 가져오기
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		bookAccountDTO.setId(memberDTO.getId());
		int result=bookAccountService.setAdd(bookAccountDTO);
		
		// 1. 동기식
		// 가입 성공여부로 message 출력 (commons/result)쪽으로 jsp 보내기 
//		String message = "상품가입이 실패";
//		if(result >0) {
//			message="상품가입 완료";
//		}
//		
//		model.addAttribute("message", message);
//		model.addAttribute("url", "../");
		
		// 2. 비동기식 
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	

}
