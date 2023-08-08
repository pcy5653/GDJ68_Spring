package com.iu.main.bookReply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.util.Pager;

@Repository
public class BookReplyDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE ="com.iu.main.bookReply.BookReplyDAO.";
	
	
	// List
	public List<BookReplyDTO> getList(BookReplyDTO bookReplyDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", bookReplyDTO);
	}
	
	// Total
	public Long getTotal()throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getList");
	}
	
	
	// Add
	public int setAdd(BookReplyDTO bookReplyDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bookReplyDTO);
	}
}
