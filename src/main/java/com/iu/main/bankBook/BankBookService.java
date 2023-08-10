package com.iu.main.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.bankBook.comment.CommentDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service // 해당 클래스에 객체 생성 (서비스역할)
public class BankBookService {
	
	//DAO 의존
	@Autowired // 아래 객체의 타입을 찾아서 변수 생성
	private BankBookDAO bankBookDAO;
	
	@Autowired
	private FileManager fileManager;
	
	// ---------------BANKBOOK
	public List<BankBookDTO> getList(Pager pager) throws Exception {
//		Map<String, Integer> map = new HashMap<String, Integer>();
		// page	 startRow  lastRow
		//  1  		1		  10
		//  2		11		  20
		//  3 		21		  30
//		int count=10;
//		int startRow=(page-1)*count+1;
//		int lastRow=page*count;

//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
		
		pager.makeRowNum();
		
		// Long타입으로 리턴한 값을 받아 pager에 담기
		Long tatal = bankBookDAO.getTotal(pager);
		pager.makePageNum(tatal);
		
		return bankBookDAO.getList(pager);
	}
	
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	
	public int setAdd(BankBookDTO bankBookDTO, MultipartFile [] photos, HttpSession session) throws Exception {
		// 1. 어디에 저장? /resources/upload/bankbook/

		String path = "/resources/upload/bankbook/";
		// insert 실행되기전에 BookNum을 검색하여 setBookNum에 집어넣는다.
		// [목표] 시퀀스로 만들어진 bookNum값을 가져와 bookNum에 넣어준다.
		// 방법1. insert 실행되기 전에 시퀀스 번호를 받아와(Mapper에서 select문 이용해 알아가지고 받아오기) setAdd를 실행할 때 변수로 시퀀스번호를 넣어준다. 
//		long num = bankBookDAO.getSequence();
//		bankBookDTO.setBookNum(num);
		
		
		
		// setAdd 실행하면서 bookNum을 찾아 DTO에 넣는다.
		int result = bankBookDAO.setAdd(bankBookDTO);
		
		// file select
		for(MultipartFile multipartFile: photos) {
			
			// 파일이 비어있다면 다시 for문으로 가라.
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, session, multipartFile);
			BankBookFileDTO bankBookFileDTO = new BankBookFileDTO();
			bankBookFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			bankBookFileDTO.setFileName(fileName);
			bankBookFileDTO.setBookNum(bankBookDTO.getBookNum());
			result = bankBookDAO.setFileAdd(bankBookFileDTO);
		}
		
		return result;
	}
	
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	
	public int setDelete(Long num) throws Exception {
		return bankBookDAO.setDelete(num);
	}
	
	
	// ---------------COMMENT 
	// list
	public List<CommentDTO> getCommentList(Pager pager, CommentDTO commentDTO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		pager.makeRowNum();
		pager.makePageNum(bankBookDAO.getCommentTotal(commentDTO));
		map.put("pager", pager);
		map.put("comment", commentDTO);
		
		return bankBookDAO.getCommentList(map);
	}
	
	// insert
	public int setCommentAdd(CommentDTO commentDTO)throws Exception{

		return bankBookDAO.setCommentAdd(commentDTO);
	}
	
}

