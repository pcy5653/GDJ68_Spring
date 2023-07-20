package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //해당 클래스의 객체 생성 (DAO 객체생성:spring에서 생성) | (DB역할)
public class BankBookDAO {
	
	@Autowired	//database-context.xml > SqlSessionFactory의 부모가 SqlSession이기에 부모 선언.
	private SqlSession sqlSession;
	
	// re
	private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";
	
	// List
	
	// detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		// 해당 namespace의 id(getDetail)를 실행하라, 보내려는 데이터
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	}
	
	
	// add
	
	// update
	
	// delete
		
}
