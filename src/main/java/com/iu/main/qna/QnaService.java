package com.iu.main.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	
	// List(total을 이용해 10개씩 간추려서 List 보여줌)
	public List<QnaDTO> getList(Pager pager) throws Exception{
		// List total (10개씩)
		pager.makeRowNum();
		Long total = qnaDAO.getTotal(pager);
		pager.makePageNum(total);
		
		return qnaDAO.getList(pager);
	}
	
	
	
	
	
	
	
	
	
}
