package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 해당 클래스에 객체 생성 (서비스역할)
public class BankBookService {
	
	//DAO 의존
	@Autowired // 아래 객체의 타입을 찾아서 변수 생성
	private BankBookDAO bankBookDAO;
	
	
	// List
	public List<BankBookDTO> getList() throws Exception {
		return bankBookDAO.getList();
	}
	
	
	// Detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
}
