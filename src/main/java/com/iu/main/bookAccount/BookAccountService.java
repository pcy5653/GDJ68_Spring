package com.iu.main.bookAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Service
public class BookAccountService {
	
	@Autowired
	private BookAccountDAO bookAccountDAO;
	
	
	// List
	public List<BookAccountDTO> getList (MemberDTO memberDTO, Pager pager) throws Exception{
		pager.makeRowNum();
		
		return bookAccountDAO.getList(memberDTO);
	}
	
	
	// Add
	public int setAdd(BookAccountDTO bookAccountDTO)throws Exception{
		
		return bookAccountDAO.setAdd(bookAccountDTO);
	}
}
