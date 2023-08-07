package com.iu.main.bookAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookAccount/*")
public class BookAccountController {
	
	@Autowired
	private BookAccountService bookAccountService;
	
	
	// Session에서 ID 꺼내오기
	
	// Add : bookNum, password를 받아오기, 파라미터로 bookNum을 받아오니 password를 입력하도록!
	@GetMapping(value = "add")
	public void setAdd(BookAccountDTO bookAccountDTO, Model model)throws Exception{
		model.addAttribute("dto", bookAccountDTO);
	}
}
