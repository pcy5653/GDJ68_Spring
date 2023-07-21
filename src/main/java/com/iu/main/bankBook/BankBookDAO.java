package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //해당 클래스의 객체 생성 (DAO 객체생성:spring에서 생성) | (DB역할)
public class BankBookDAO {
	
	@Autowired	
	//database-context.xml > SqlSessionFactory의 부모가 SqlSession이기에 부모 선언.
	private SqlSession sqlSession;
	
	// *Mapper 파일 위치
	private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";
	
	// List : 여러개 추출(List(부모) > ArrayList(자))
	public List<BankBookDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	
	// detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		// 해당 namespace(Mapper)의 id(getDetail)를 실행하라, 보내려는 데이터
		// sqlSession : DB연결, Mapper 위치
		// selectOne : 메소드를 통해 select 실행-> executeQuery (insert+update_delete일 때는 executeUpdate)
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	}
	
	
	// add
	
	// update
	
	// delete
		
}
