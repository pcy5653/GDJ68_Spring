package com.iu.main.bookAccount;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Repository
public class BookAccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.main.bookAccount.BookAccountDAO.";
	
	
	
	// List : 존재하지 않는 id를 작성했을 시, 오류발생
	public List<BookAccountDTO> getList(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", memberDTO);
	}
	
	// Total
	public Long getTotal(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
	
	
	// Detail
	public int getDetail(BookAccountDTO bookAccountDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", bookAccountDTO);
	}
	
	
	// Add : 존재하지 않는 bookNum을 대입했을 시, 오류발생
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
