package com.iu.main.notice;

import java.sql.Date;

public class NoticeDTO {
	private Integer noticeNum;
	private String noticeName;
	private String noticeTitle;
	private String noticeContents;
	private Date noticeDate;
	private Integer noticeHit;
	
	
	
	public Integer getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(Integer noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeName() {
		return noticeName;
	}
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public Integer getNoticeHit() {
		return noticeHit;
	}
	public void setNoticeHit(Integer noticeHit) {
		this.noticeHit = noticeHit;
	}
	
	
	
	
	
	
}
