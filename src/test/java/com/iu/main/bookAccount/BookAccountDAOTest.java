package com.iu.main.bookAccount;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;
import com.iu.main.util.Pager;

public class BookAccountDAOTest extends Mytest {
	
	@Autowired
	private BookAccountDAO bookAccountDAO;
	@Autowired
	private Pager pager;
	
//	@Test
//	public void setAddTest() throws Exception{
//		BookAccountDTO bookAccountDTO = new BookAccountDTO();
//		
//		for(int i=0; i<10; i++) {
//			bookAccountDTO.setId("채연");
//			bookAccountDTO.setBookNum(85);
//			bookAccountDTO.setAccount(1234);
//			bookAccountDTO.setAccountPassword(9999);
//			bookAccountDTO.setAccountBalance(20231231);
//			
//			bookAccountDAO.setAdd(bookAccountDTO);
//			}
//	}
}
