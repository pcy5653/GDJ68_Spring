package com.iu.main.noticeTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;
import com.iu.main.notice.NoticeDAO;
import com.iu.main.notice.NoticeDTO;
import com.iu.main.notice.NoticeService;

// Mytest 상속받아 annotation 작성하지 않아도 사용가능
public class NoticeDAOTest extends Mytest {
	
	@Autowired
	private NoticeService noticeService;
	
	@Test
	public void getList() throws Exception {
		List<NoticeDTO> ar = noticeService.getList();
		assertNotEquals(0, ar.size());
	}

}
