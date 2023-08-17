package com.iu.main.errors;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

// 예외처리 Controller 역할을 하는 Annotation
@ControllerAdvice
public class ErrorController {
	
	// app 내에서 발생하는 모든 Exception을 처리하는 Controller
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String frontError()throws Exception{
		return "error/front_error";
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public String error1()throws Exception{
		// 1. Null 처리
		return "error/front_error";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public void error2()throws Exception{
		// 2. type 오류 처리
	}
	
	@ExceptionHandler(Exception.class)
	public String error3(Exception ex)throws Exception{
		// 3. 모든 Exception 처리
		System.out.println(ex.getMessage());
		return "error/front_error";
	}
}
