package com.iu.main.bookAccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;
import com.iu.main.member.MemberDTO;


public class BookAccountDAOTest extends Mytest {
	
	@Autowired
	private BookAccountDAO dao;
	
	// List
	// 없는 ID를 대입했을 때 ERROR 발생
	// 있는 ID를 대입했을 때 정상작동
	
//	@Test
//	public void getListTest() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		
//		memberDTO.setId("111");
//		List<BookAccountDTO> ar = dao.getList(memberDTO);
//		
//		// ar에 size가 없는 것을 알기 때문에 true 작동
//		assertEquals(0, ar.size());
//	}

	
	// Add
	// 없는 bookNum를 대입했을 때 ERROR 발생
	// 있는 bookNum를 대입했을 때 정상작동
	@Test
	public void setAddTest() throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setId("sunday1");
		dto.setBookNum(1L);
		dto.setAccount(123456L);
		dto.setAccountBalance(0L);
		dto.setAccountPassword("0000");
		
		int result = dao.setAdd(dto);
		
		assertEquals(1, result);
	}
}
