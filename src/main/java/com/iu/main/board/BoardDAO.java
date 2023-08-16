package com.iu.main.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.Pager;

public interface BoardDAO {
	
	// NoticeDTO, QnaDTO 둘다 매개변수로 받기 위해 상속받는 BoardDTO를 매개변수로 설정
	
	//List
	public List<BoardDTO> getList(Pager pager)throws Exception;
	

		
	//Add
	public int setAdd(BoardDTO boardDTO)throws Exception;
	
	//Detail
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
		
	//Update
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	//Delete
	public int setDelete(Map<String, Object> map)throws Exception;
	
	//totalCount(10개씩)
	public Long getTotal(Pager pager) throws Exception;
	
	// 조회수 업데이트
	public int setHitUpdate(BoardDTO boardDTO)throws Exception;
}
