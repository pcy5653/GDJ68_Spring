package com.iu.main.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.board.notice.NoticeFileDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;
	
	
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
		String path = "/resources/upload/qna";
		
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
		
		String path = "/resuorces/uploade/qna/";
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


	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}


	
	
	
	
	
	
}
