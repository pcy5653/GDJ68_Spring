package com.iu.main.bookReply;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@RequestMapping("/bookReply/*")
@Controller
public class BookReplyController {

	@Autowired
	private BookReplyService bookReplyService;	
	
	
	
	// List
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(BookReplyDTO bookReplyDTO, Pager pager, Model model)throws Exception{
		
		List<BookReplyDTO> ar = bookReplyService.getList(bookReplyDTO);
		System.out.println(bookReplyDTO.getBookNum());
		model.addAttribute("list", ar);
		
		return "bookReply/list";
	}
}
