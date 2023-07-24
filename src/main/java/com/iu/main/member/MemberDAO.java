package com.iu.main.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired	// 객체생성한뒤 꼭 주입!!!!
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.member.MemberDAO.";
	
	
	// 로그인	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
	
	// 회원수정
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
}
