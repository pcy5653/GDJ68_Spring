package com.iu.main.bankBook.comment;

import java.sql.Date;

public class CommentDTO {
	private Long commentNum;
	private String id;
	private Long bookNum;
	private String commnetContents;
	private Date commentDate;
	public Long getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Long commentNum) {
		this.commentNum = commentNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getCommnetContents() {
		return commnetContents;
	}
	public void setCommnetContents(String commnetContents) {
		this.commnetContents = commnetContents;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
}
