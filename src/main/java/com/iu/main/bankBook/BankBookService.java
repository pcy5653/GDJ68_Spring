package com.iu.main.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 해당 클래스에 객체 생성 (서비스역할)
public class BankBookService {
	
	//DAO 의존
	@Autowired // 아래 객체의 타입을 찾아서 변수 생성
	private BankBookDAO bankBookDAO;
	
	public void service() {
		System.out.println("service");
		bankBookDAO.dao(); //@Autowired로 해당 타입찾아서 변수 생성하여 메소드 사용가능
	}
}
