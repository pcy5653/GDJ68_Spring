package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 해당 클래스에 객체 생성 (서비스역할)
public class BankBookService {
	
	//DAO 의존
	@Autowired // 아래 객체의 타입을 찾아서 변수 생성
	private BankBookDAO bankBookDAO;
	
	
	public List<BankBookDTO> getList() throws Exception {
		return bankBookDAO.getList();
	}
	
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	
	public int setAdd(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setAdd(bankBookDTO);
	}
	
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	
	public int setDelete(Long num) throws Exception {
		return bankBookDAO.setDelete(num);
	}
}
