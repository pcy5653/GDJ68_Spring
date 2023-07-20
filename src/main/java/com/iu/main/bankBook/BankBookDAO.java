package com.iu.main.bankBook;

import org.springframework.stereotype.Repository;

@Repository //해당 클래스의 객체 생성 (DAO 객체생성:spring에서 생성) | (DB역할)
public class BankBookDAO {
	
	public void dao() {
		
		System.out.println("dao");
		
	}
}
