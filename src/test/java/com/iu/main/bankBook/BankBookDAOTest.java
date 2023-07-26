package com.iu.main.bankBook;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;

public class BankBookDAOTest extends Mytest{
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getListTest() throws Exception{
		// DAO로 보낼 2개의 파라미터를 
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", 11);
		map.put("lastRow", 20);
		
		List<BankBookDTO> ar =bankBookDAO.getList(map);
		System.out.println(ar.get(0).getBookNum());
		System.out.println(ar.get(9).getBookNum());
	}
	
	
	//@Test
	public void addTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		for(int i=0; i<30; i++) {
			
			bankBookDTO.setBookName("국민은행"+i);
			bankBookDTO.setBookContents("국민은행 내용"+i);
			bankBookDTO.setBookRate(2.6);
			bankBookDTO.setBookSale(1);
			
			bankBookDAO.setAdd(bankBookDTO);
		}
		
		System.out.println("Finish");
	}

}


