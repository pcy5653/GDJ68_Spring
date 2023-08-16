package com.iu.main.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.notice.NoticeFileDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	// jsp H1의 이름
	// @ModelAttribute : @RequestMapping이 실행되기 전에(list, add, ...) 실행되고, board(키)로 notice(value)를 담아 보낸다.
	@ModelAttribute("board")
	public String getBoardName() {
		return "qna";
	}
		
		
	
	// List
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model)throws Exception {
		
		List<BoardDTO> ar = qnaService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	// detail
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(QnaDTO qnaDTO, ModelAndView mv)throws Exception {
		qnaDTO = (QnaDTO)qnaService.getDetail(qnaDTO);
		mv.setViewName("board/detail");
		mv.addObject("dto",qnaDTO);
		
		return mv;
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
	
	
	
	@RequestMapping(value="reply", method = RequestMethod.GET)
	public String setReplyAdd(Long num, Model model, QnaDTO qnaDTO)throws Exception {
		model.addAttribute("num", num);
		model.addAttribute(qnaDTO);
		
		return "board/reply";
	}
	// detail > 답글
	@RequestMapping(value="reply", method = RequestMethod.POST)
	public String setReplyAdd(QnaDTO qnaDTO, MultipartFile [] photos, HttpSession session)throws Exception {
		int result = qnaService.setReplyAdd(qnaDTO, photos, session);
		return "redirect:./list";
	}
	
	
	
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String setUpdate(QnaDTO qnaDTO, Model model) throws Exception {
		qnaDTO = (QnaDTO)qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
		
		return "board/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(QnaDTO qnaDTO, MultipartFile [] photos, HttpSession session) throws Exception {
		int result = qnaService.setUpdate(qnaDTO, photos, session);

		return "redirect:./detail?num="+qnaDTO.getNum();
	}
	
	// 수정 중 파일 삭제
	@GetMapping("fileDelete")
	public String setFileDelete(QnaFileDTO qnaFileDTO,HttpSession session, Model model)throws Exception{
		int result = qnaService.setFileDelete(qnaFileDTO, session);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	
	
	
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public String setDelete(QnaDTO qnaDTO, HttpSession session)throws Exception {
		int result = qnaService.setDelete(qnaDTO, session);
		
		return "redirect:./list";
	}
}
