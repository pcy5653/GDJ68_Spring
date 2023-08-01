package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// jsp H1의 이름
	// @ModelAttribute : @RequestMapping이 실행되기 전에(list, add, ...) 실행되고, board(키)로 notice(value)를 담아 보낸다.
	@ModelAttribute("board")
	public String getBoardName() {
		return "notice";
	}
	
	
	@RequestMapping(value="list")
	public String getList(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = noticeService.getList(pager);

		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(NoticeDTO noticeDTO, ModelAndView mv) throws Exception {
		// 만들어진 것 : NoticeDTO | 담아오는 것 : BoardDTO
		BoardDTO boardDTO = noticeService.getDetail(noticeDTO);
		mv.setViewName("board/detail");
		// jsp에서 실행할 변수의 키(notice)의 이름을 jsp에서 정확하게 작성하자!
		mv.addObject("dto", boardDTO);
		
		return mv;
	}
	
	
	
	// Form Add(insert)
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		
		return "board/add";
	}
	
	// DB Add(insert)
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(NoticeDTO noticeDTO, MultipartFile [] photos, HttpSession session) throws Exception {
		int result = noticeService.setAdd(noticeDTO, photos, session);
		
		return "redirect:./list";
	}
	
	
	// Update
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String setUpdate(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", boardDTO);
		
		return "board/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		
		
		// detail에는 하나의 내용을 보여주기 때문에 URL 자체에 detail?noticeNum=원하는번호(변수=noticeDTO.getNoticeNum())로 해당 상세내용을 본다!!
		return "redirect:./detail?num="+noticeDTO.getNum();
	}
	
	
	
	// Delete
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String setDelete(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.setDelete(noticeDTO);
		
		// redirect로 리턴하지 않으면 해당 num의 삭제된 list만 보여준다.
		return "redirect:./list";
	}
	
	
	
	
	
	
}
