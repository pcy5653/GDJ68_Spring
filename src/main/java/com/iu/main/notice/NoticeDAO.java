package com.iu.main.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.notice.NoticeDAO.";
	
	// List
	public List<NoticeDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	// Detail
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
	}
	
	// Add(insert)
	public int setAdd(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", noticeDTO);
	}
	
	//update
	public int setUpdate(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);
	}
	
	// Delete
	public int setDelete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", noticeDTO);
	}
}
