package com.iu.main.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping(value="list")
	public String getList(Pager pager, Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.getList(pager);

		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(NoticeDTO noticeDTO, ModelAndView mv) throws Exception {
		noticeDTO = noticeService.getDetail(noticeDTO);
		mv.setViewName("board/detail");
		mv.addObject("notice", noticeDTO);
		
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
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("notice", noticeDTO);
		
		return "board/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		
		// detail에는 하나의 내용을 보여주기 때문에 URL 자체에 detail?noticeNum=원하는번호(변수=noticeDTO.getNoticeNum())로 해당 상세내용을 본다!!
		return "redirect:./detail?noticeNum="+noticeDTO.getNoticeNum();
	}
	
	
	
	// Delete
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String setDelete(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.setDelete(noticeDTO);
		
		// redirect로 리턴하지 않으면 해당 num의 삭제된 list만 보여준다.
		return "redirect:./list";
	}
	
	
	
	
	
	
}
