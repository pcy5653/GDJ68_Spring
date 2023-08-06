package com.iu.main.bookAccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.util.Pager;

public class BookAccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.main.bookAccount.BookAccountDAO.";
	
	
	
	// List
	public List<BookAccountDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	// Total
	public Long getTotal(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
	
	
	// Detail
	public int getDetail(BookAccountDTO bookAccountDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", bookAccountDTO);
	}
	
	
	// Add
	public int setAdd(BookAccountDTO bookAccountDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bookAccountDTO);
	}
	
	
	// Update 
	public int setUpdate(BookAccountDTO bookAccountDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate",bookAccountDTO);
	}
	
	
	// Delete
	public int setDelete (BookAccountDTO bookAccountDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", bookAccountDTO);
	}
}
