package com.iu.main.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	
	// List
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model)throws Exception {
		
		List<BoardDTO> ar = qnaService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	
	// Add
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String setAdd()throws Exception {
		return "board/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(QnaDTO qnaDTO, MultipartFile [] photos, HttpSession session)throws Exception {
		int result = qnaService.setAdd(qnaDTO, photos, session);
		
		return "redirect:./list";
	}
	
	
	// detail
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(QnaDTO qnaDTO, ModelAndView mv)throws Exception {
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		mv.setViewName("board/detail");
		mv.addObject("notice",boardDTO);
		
		return mv;
	}
}
