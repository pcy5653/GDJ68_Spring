package com.iu.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	// List
	public List<NoticeDTO> getList() throws Exception {
		return noticeDAO.getList();
	}
	
	// Detail
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.getDetail(noticeDTO);
	}
	
	// Add(insert)
	public int setAdd(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setAdd(noticeDTO);
	}
	
	// Update
	public int setUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	// Delete
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setDelete(noticeDTO);
	}
}
