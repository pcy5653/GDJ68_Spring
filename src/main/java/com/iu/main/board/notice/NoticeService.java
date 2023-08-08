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
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception{
		int result = noticeDAO.setUpdate(boardDTO);
		
		String path = "/resources/upload/notice/";
		// file select
			for(MultipartFile multipartFile: files) {
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
	// 수정 중 파일 삭제 (fileNum 변수)
	public int setFileDelete(NoticeFileDTO noticeFileDTO, HttpSession session)throws Exception{
		// 1. 폴더 파일 삭제 
		// fileNum으로 fileName을 조회하기
		noticeFileDTO = noticeDAO.getFileDetail(noticeFileDTO);
		// fileName, resources/upload/파일위치, 회원만!
		boolean check = fileManager.fileDelete(noticeFileDTO, "/resources/upload/notice/", session);
		
		// 2. DB 삭제 : 폴더파일 먼저 삭제된 뒤, DB 삭제
		if(check) {
			return noticeDAO.setFileDelete(noticeFileDTO);
		}
		
		// 2. 위의 if문 실행 안된다면 0
		return 0;
	}
	
	// Delete
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
}
