package com.iu.main.bookAccount;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Service
public class BookAccountService {
	
	@Autowired
	private BookAccountDAO bookAccountDAO;
	
	
	// List
	public List<BookAccountDTO> getList (MemberDTO memberDTO, Pager pager) throws Exception{
		// mypage의 상품가입목록 3개씩 출력.
		pager.setPerPage(3L);
		pager.makeRowNum();
		
		// page가 총 몇page인지
		pager.makePageNum(bookAccountDAO.getTotal());
		
		// memberDTO와 pager 합쳐 getList 실행
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", memberDTO);
		map.put("pager", pager);
		
		return bookAccountDAO.getList(map);
	}
	
	
	// Add
	public int setAdd(BookAccountDTO bookAccountDTO)throws Exception{
		Calendar ca = Calendar.getInstance();
		// 1. 통장번호를 uniqe 설정하기 위해 calendar로 통장번호 설정.
		bookAccountDTO.setAccount(ca.getTimeInMillis());
		
		return bookAccountDAO.setAdd(bookAccountDTO);
	}
}
