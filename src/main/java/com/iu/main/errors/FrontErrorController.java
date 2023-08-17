package com.iu.main.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error/*")
public class FrontErrorController {
	
	// 400번대 front 오류 처리
	@GetMapping("front")
	public String front()throws Exception{
		return "errors/front_error";
	}
}
