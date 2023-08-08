package com.iu.main.bookReply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class BookReplyService {
	@Autowired
	private BookReplyDAO bookReplyDAO;
	
	
	
	// List
	public List<BookReplyDTO> getList(BookReplyDTO bookReplyDTO)throws Exception{
		return bookReplyDAO.getList(bookReplyDTO);
	}
	
	
	// Add
	public int setAdd(BookReplyDTO bookReplyDTO)throws Exception{
		return bookReplyDAO.setAdd(bookReplyDTO);
	}
}
