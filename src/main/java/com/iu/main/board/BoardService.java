package com.iu.main.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.Pager;

public interface BoardService {
	
	//list
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	//add
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session)throws Exception;
	
	//update
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	//delete
	public int setDelete(BoardDTO boardDTO)throws Exception;
}
