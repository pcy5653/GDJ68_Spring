package com.iu.main.student;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository	// DAO 역할 = Repository
public class StudentDAO {
	
	@Autowired	// DB연결 및 Mapper 연결
	private SqlSession sqlSession;
	
	// 원하는 Mapper의 위치
	private final String NAMESPACE="com.iu.main.student.StudentDAO."; 
	
	
	// List -> 여러개의 내용 출력(List<E> > ArrayList<E>)
	public List<StudentDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	
	// Detail -> 하나의 내용만 출력
	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", studentDTO);
	}
	
	
	// Form add(insert)
	public int setAdd(StudentDTO studentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", studentDTO);
	}
	
	// DB Insert
}
