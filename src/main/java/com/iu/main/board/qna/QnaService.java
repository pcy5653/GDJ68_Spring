package com.iu.main.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.board.notice.NoticeFileDTO;
import com.iu.main.file.FileDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;
	
	
	
	// 이미지 업로드 시 : 위지위그
	   public String setContentsImg(MultipartFile file, HttpSession session)throws Exception{
	      // 경로를 받아 contents 부분에 뿌림(DB X)
	      String path ="/resources/upload/qna/";
	      String fileName =fileManager.fileSave(path, session, file);
	      // 이미지 폴더 + 파일명
	      return path+fileName;
	   }
	   // 이미지 삭제 시 : 위지위그
	   public boolean setContentsImgDelete(String path, HttpSession session)throws Exception{
	      // path : /resources/upload/notice/파일명
	      // 경로명을 제외한 파일명만 삭제한다.
	      FileDTO fileDTO = new FileDTO();
	      // path에서 파일명만 가져와서 setFileName으로 가져온다.
	      fileDTO.setFileName(path.substring(path.lastIndexOf("/")+1));
	      path = "/resources/upload/qna/";
	      return fileManager.fileDelete(fileDTO, path, session);
	   }
	
   
	// List(total을 이용해 10개씩 간추려서 List 보여줌)
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		// List total (10개씩)
		pager.makeRowNum();
		Long total = qnaDAO.getTotal(pager);
		pager.makePageNum(total);
		// 위에 2줄 1줄 압축
		//pager.makePageNum(qnaDAO.getTotal(pager));
		
		return qnaDAO.getList(pager);
	}
	
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}


	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		String path = "/resources/upload/qna/";
		
		// qnaNum을 DTO 대입
		int result = qnaDAO.setAdd(boardDTO);
		
		// file select
		for(MultipartFile multipartFile: files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName=fileManager.fileSave(path, session, multipartFile);
			
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			qnaFileDTO.setNum(boardDTO.getNum());
			result = qnaDAO.setFileAdd(qnaFileDTO);
		}
		return result;
	}
	
	public int setReplyAdd(QnaDTO qnaDTO, MultipartFile [] files, HttpSession session) throws Exception {
		
		// 부모 글번호를 따로 빼서 REF, STEP, DEPTH 구하기
		BoardDTO parentDTO = new BoardDTO();
		parentDTO.setNum(qnaDTO.getNum());
	
		parentDTO=qnaDAO.getDetail(parentDTO);
		QnaDTO p = (QnaDTO)parentDTO;
		qnaDTO.setRef(p.getRef());
		qnaDTO.setStep(p.getStep()+1);
		qnaDTO.setDepth(p.getDepth()+1);
		
		
		// p에 있는 부모의 num으로 step을 계산하기 때문에 setReplyAdd 하기 전에 실행
		int result = qnaDAO.setStepUpdate(qnaDTO);
		
		result = qnaDAO.setReplyAdd(qnaDTO);
		
		// file 저장
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
		int result = qnaDAO.setUpdate(boardDTO);
		
		String path = "/resources/upload/qna/";
		// file select
		for (MultipartFile multipartFile:files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, session, multipartFile);
			
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			qnaFileDTO.setNum(boardDTO.getNum());
			
			result = qnaDAO.setFileAdd(qnaFileDTO);
		}
		
		return result;
	}
	
	// 수정 중 파일 삭제 (fileNum 변수)
   public int setFileDelete(QnaFileDTO qnaFileDTO, HttpSession session)throws Exception{
      // 1. 폴더 파일 삭제 
      // fileNum으로 fileName을 조회하기
      qnaFileDTO = qnaDAO.getFileDetail(qnaFileDTO);
      // fileName, resources/upload/파일위치, 회원만!
      boolean check = fileManager.fileDelete(qnaFileDTO, "/resources/upload/qna/", session);
      
      // 2. DB 삭제 : 폴더파일 먼저 삭제된 뒤, DB 삭제
      if(check) {
         return qnaDAO.setFileDelete(qnaFileDTO);
      }
      
      // 2. 위의 if문 실행 안된다면 0
      return 0;
   }


	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}

}
