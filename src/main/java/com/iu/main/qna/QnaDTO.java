package com.iu.main.qna;

import java.sql.Date;

public class QnaDTO {
	private Integer qnaNum;
	private String qnaName;
	private String qnaTitle;
	private String qnaContents;
	private Date qnaDate;
	private Integer qnaHit;
	private Integer qnaRef;
	private Integer qnaStep;
	private Integer qnaDepth;
	
	
	
	public Integer getQnaNum() {
		return qnaNum;
	}
	public void setQnaNum(Integer qnaNum) {
		this.qnaNum = qnaNum;
	}
	public String getQnaName() {
		return qnaName;
	}
	public void setQnaName(String qnaName) {
		this.qnaName = qnaName;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContents() {
		return qnaContents;
	}
	public void setQnaContents(String qnaContents) {
		this.qnaContents = qnaContents;
	}
	public Date getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}
	public Integer getQnaHit() {
		return qnaHit;
	}
	public void setQnaHit(Integer qnaHit) {
		this.qnaHit = qnaHit;
	}
	public Integer getQnaRef() {
		return qnaRef;
	}
	public void setQnaRef(Integer qnaRef) {
		this.qnaRef = qnaRef;
	}
	public Integer getQnaStep() {
		return qnaStep;
	}
	public void setQnaStep(Integer qnaStep) {
		this.qnaStep = qnaStep;
	}
	public Integer getQnaDepth() {
		return qnaDepth;
	}
	public void setQnaDepth(Integer qnaDepth) {
		this.qnaDepth = qnaDepth;
	}
	
	
	
}
