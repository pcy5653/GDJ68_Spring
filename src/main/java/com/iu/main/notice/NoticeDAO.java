package com.iu.main.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.util.Pager;


@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.notice.NoticeDAO.";
	
	
	//total | Service 받을 때 Long 타입
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
	
	// List
	public List<NoticeDTO> getList(Pager pager) throws Exception{
		// 파라미터로 total의 데이터를 넣은 pager를 받아 리턴
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	// Detail
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
	}
	
	// Add(insert)
	public int setAdd(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", noticeDTO);
	}
	
	// file Add
	public int setFileAdd(NoticeFileDTO noticeFileDTO) {
		return sqlSession.insert(NAMESPACE+"setFileAdd",noticeFileDTO);
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
