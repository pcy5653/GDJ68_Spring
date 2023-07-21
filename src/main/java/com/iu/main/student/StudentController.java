package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller		// Controller 역할
@RequestMapping("/student/*")	// /student/* => student 경로로 들어오는 모든 파일을 처리하라
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	// List
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv) throws Exception {
		List<StudentDTO> ar = studentService.getList();
		mv.addObject("list", ar);
		mv.setViewName("student/list");
		return mv; 
	}
	
	
	// Detail
	@RequestMapping(value="detail")
	public String getDetail(StudentDTO studentDTO, Model model) throws Exception {
		studentDTO = studentService.getDetail(studentDTO);
		model.addAttribute("dto", studentDTO);
		
		return "student/detail";
	}
	
	
	// Form insert(add)
	@RequestMapping()
	public void setAdd() throws Exception {
		
	}
	
	
	
	
	
	
}















