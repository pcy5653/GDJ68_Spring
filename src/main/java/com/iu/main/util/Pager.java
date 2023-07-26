package com.iu.main.util;

// 계산식 등 여러곳에 사용되는 코드 집합
// 현재 notice의 페이징 처리
public class Pager {
	// startRow, lastRow : data를 보여주는 범위의 첫번째와 마지막번호
	private Long startRow;
	private Long lastRow;

	// 현재 페이지 위치 | 1,2,3,4....
	private Long page;
	
	// 한 페이지에 보여질 DATA(Row)의 갯수 | 현재 10개씩 보여줌
	private Long perPage;
	
	// 총 페이지의 갯수
	private Long totalPage;
	
	// 시작번호
	private Long startNum;
	// 끝번호
	private Long lastNum;
	
	
	// 1. 보여지는 data 갯수 계산 method
	public void makeRowNum() {
		//getPage = Null이 오면 1을 받을 수 있도록 설정 (getter 확인)
		//getPerPage = Null이 오면 10을 받을 수 있도록 설정 (getter 확인)
		
		// page		startRow	lastRow
		// 	1			1			10
		//  2			11			20		
		//  3			21			30
		this.startRow=(this.getPage()-1)*this.getPerPage()+1;
		this.lastRow=this.getPage()*this.getPerPage();
	}
	
	// 2. 총 data 갯수에 따른 페이지 출력 method, List 하단에 페이지 출력
	// ex) 130개 13page | 134개 14page | 149개 15page
	public void makePageNum(Long total) {
		
		// 1. 전체 갯수로 전체 페이지 수 구하기
		// 나눈만큼 페이지를 주고 if문 실행해서 해당되면 증가한다.
		this.totalPage=total/this.getPerPage();
		if(total%this.getPerPage() != 0) {
			this.totalPage++;
		}
		
		// 2. 전체 페이지수로 전체 block 수 구하기
		// 한 페이지에 출력할 번호의 갯수 (5개씩 1개 블럭)
		long perBlock=5;
		
		long totalBlock = this.totalPage/perBlock;
		if(this.totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		// 3. 현재 page 번호로 블럭번호 구하기
		// 현재 블럭 번호
		long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		
		// 4. 현재 블럭번호의 시작번호와 끝번호 구하기
		// curBlock		startNum	lastNum
		//     1			1			5
		//	   2			6			10
		// 	   3			11			15
		this.startNum= (curBlock-1)*perBlock +1;
		this.lastNum= curBlock*perBlock;
	}
	
	
	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}	
	
	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	// NULL 대비
	public Long getPage() {
		if(this.page==null) {
			this.page=1L;
		}
		
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}
	
	// NULL 대비
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
}
