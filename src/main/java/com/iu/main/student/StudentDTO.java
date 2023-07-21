package com.iu.main.student;

public class StudentDTO {
	private Long studNum;
	private String studName;
	private Integer kor;
	private Integer eng;
	private Integer math;
	private Integer total;
	private Double avg;
	
	
	public Long getStudNum() {
		return studNum;
	}
	public void setStudNum(Long studNum) {
		this.studNum = studNum;
	}
	
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	public Integer getKor() {
		return kor;
	}
	public void setKor(Integer kor) {
		this.kor = kor;
	}
	
	public Integer getEng() {
		return eng;
	}
	public void setEng(Integer eng) {
		this.eng = eng;
	}
	
	public Integer getMath() {
		return math;
	}
	public void setMath(Integer math) {
		this.math = math;
	}
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	//오버로딩
	public void setTotal() {
		this.total = kor+eng+math;
	}
	
	
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	//오버로딩
	public void setAvg() {
		this.avg = total/3.0;
	}
}
