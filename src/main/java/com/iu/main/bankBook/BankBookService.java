package com.iu.main.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service // 해당 클래스에 객체 생성 (서비스역할)
public class BankBookService {
	
	//DAO 의존
	@Autowired // 아래 객체의 타입을 찾아서 변수 생성
	private BankBookDAO bankBookDAO;
	
	
	public List<BankBookDTO> getList(Pager pager) throws Exception {
//		Map<String, Integer> map = new HashMap<String, Integer>();
		// page	 startRow  lastRow
		//  1  		1		  10
		//  2		11		  20
		//  3 		21		  30
//		int count=10;
//		int startRow=(page-1)*count+1;
//		int lastRow=page*count;

//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
		
		pager.makeRowNum();
		
		// Long타입으로 리턴한 값을 받아 pager에 담기
		Long tatal = bankBookDAO.getTotal(pager);
		pager.makePageNum(tatal);
		
		return bankBookDAO.getList(pager);
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
