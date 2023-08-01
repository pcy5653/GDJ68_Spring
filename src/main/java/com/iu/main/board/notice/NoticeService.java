package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	
	
	// List
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		// List total
		pager.makeRowNum();
		Long total = noticeDAO.getTotal(pager);
		pager.makePageNum(total);
		
		return noticeDAO.getList(pager);
	}
	
	// Detail
	@Override
	public NoticeDTO getDetail(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getDetail(boardDTO);
	}
	
	// Add(insert)
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] photos, HttpSession session) throws Exception{
		// 1. 어디에 저장?
		String path = "/resources/upload/notice/";
		
		// setAdd를 실행하면서 noticeNum을 찾아 DTO 대입
		int result = noticeDAO.setAdd(boardDTO);
		
		// file select
		for(MultipartFile multipartFile: photos) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName=fileManager.fileSave(path, session, multipartFile);
			
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			noticeFileDTO.setNoticeNum(boardDTO.getNum());
			result = noticeDAO.setFileAdd(noticeFileDTO);
		}
		
		return result;
	}
	
	// Update
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}
	
	// Delete
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
}
