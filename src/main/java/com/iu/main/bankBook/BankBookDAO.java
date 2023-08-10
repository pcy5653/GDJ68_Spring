package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.bankBook.comment.CommentDTO;
import com.iu.main.util.Pager;

@Repository //해당 클래스의 객체 생성 (DAO 객체생성:spring에서 생성) | (DB역할)
public class BankBookDAO {
	
	@Autowired	
	//database-context.xml > SqlSessionFactory의 부모가 SqlSession이기에 부모 선언.
	private SqlSession sqlSession;
	
	// *Mapper 파일 위치
	private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";
	
	//------- BANKBOOK LIST
	
	// total : List의 페이지 넘버 보여주기
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
	
	
	// List : 여러개 추출(List(부모) > ArrayList(자))
	public List<BankBookDTO> getList(Pager pager) throws Exception{
		// 파라미터로 List의 갯수를 보내주는 데이터 2개를 보내준다.
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	
	// detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		// 해당 namespace(Mapper)의 id(getDetail)를 실행하라, 보내려는 데이터
		// sqlSession : DB연결, Mapper 위치
		// selectOne : 메소드를 통해 select 실행-> executeQuery (insert+update_delete일 때는 executeUpdate)
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	}
	
	
	// add
	// insert, update, delete는 리턴값으로 int(정수, 0~1이상 말함)를 보낸다 => colurm의 추가 실패 =0, 추가&수정&삭제 성공 = 1이상
	public int setAdd(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bankBookDTO);
	}
	
	// file add
	public int setFileAdd(BankBookFileDTO bankBookFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setFileAdd", bankBookFileDTO);
	}
	
//	// sequence 받기
//		public long getSequence() throws Exception{
//			return sqlSession.selectOne(NAMESPACE+"getSequence");
//		}
	
	
	// update
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}	
	
	
	// delete
	// DTO가 아닌 하나의 데이터를 보내는 변수(num)를 따라 Mapper에서도 똑같이 ParameterType도 동일타입으로 설정하고 받는 변수 값도 동일작성
	public int setDelete(Long num) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}
	
	
	
	// COMMENT LIST
	public List<CommentDTO> getCommentList(Map<String, Object> map) throws Exception{
		// 파라미터로 List의 갯수를 보내주는 데이터 2개를 보내준다.
		return sqlSession.selectList(NAMESPACE+"getCommentList", map);
	}
	
	public Long getCommentTotal(CommentDTO commentDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCommentTotal", commentDTO);
	}
		
}
