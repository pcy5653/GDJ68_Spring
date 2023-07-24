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
	
	
    // Form insert(add.jsp 경로)
    @RequestMapping(value="add", method=RequestMethod.GET)
    public String setAdd() throws Exception {
        return "student/add";
    }
    //DB insert (add form의 method가 POST이니 작성된 페이지에서 전송될 때 작동하는 METHOD)
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String setAdd(StudentDTO studentDTO) throws Exception {
        studentDTO.setTotal();
        studentDTO.setAvg();
        // int로 받은 건 성공여부에 따른 값이 정수(int, 0~1 표현)이기에 
        int result = studentService.setAdd(studentDTO);
        return "redirect:./list";
    }
    // Form update(update.jsp 경로)
    @RequestMapping(value="update", method=RequestMethod.GET)
    public ModelAndView setUpdate (StudentDTO studentDTO, ModelAndView mv) throws Exception {
        mv.setViewName("student/update");
        mv.addObject("dto", studentDTO);
        return mv;
    }
    @RequestMapping(value="update", method=RequestMethod.POST)
    public String setUpdate(StudentDTO studentDTO) throws Exception {
    	studentDTO.setTotal();
    	studentDTO.setAvg();
        int result = studentService.setUpdate(studentDTO);
        return "redirect:./list";
    }
    
    // delete(삭제확인 여부 => 정수(int) 출력 | 클라이언트에 의해 DB내용 변화이기에 redirect 사용)
    @RequestMapping(value="delete", method=RequestMethod.GET)
    public String setDelete(StudentDTO studentDTO) throws Exception {
        int result = studentService.setDelete(studentDTO);
        return "redirect:./list";
    } 
	
	
	
	
	
	
}















