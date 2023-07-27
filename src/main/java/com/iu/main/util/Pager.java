package com.iu.main.util;

// 계산식 등 여러곳에 사용되는 코드 집합
// 현재 notice의 페이징 처리
public class Pager {
	// startRow, lastRow : data를 보여주는 범위의 첫번째와 마지막번호
	// Mapper 받아와 jsp 사용하기 위함
	private Long startRow;
	private Long lastRow;

	// 현재 페이지 위치 | 1,2,3,4.... | parameter 값 
	private Long page;
	
	// 한 페이지에 보여질 DATA(Row)의 갯수 | 현재 10개씩 보여줌
	private Long perPage;
	
	// 총 페이지의 갯수 
	private Long totalPage;
	
	// 시작번호
	private Long startNum;
	// 끝번호
	private Long lastNum;
	
	// 이전블럭 활성화(기본값 : false)
	private boolean pre;	// false면 1번 블럭, true면 1번 아님
	// 다음블럭 활성화
	private boolean next;	// false면 마지막블럭, true면 마지막 아님
	
	
	// 검색
	private String kind;
	private String search;



	// 1. 보여지는 data 갯수 계산 method
	public void makeRowNum() {
		//getPage = Null이 오면 1을 받을 수 있도록 설정 (getter 확인)
		//getPerPage = Null이 오면 10을 받을 수 있도록 설정 (getter 확인)
		
		// page		startRow	lastRow
		// 	1			1			10
		//  2			11			20		
		//  3			21			30
		
		//		int count=10;
		//		int startRow=(page-1)*count+1;
		//		int lastRow=page*count;
		
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
		// totalBlock으로 처음과 마지막 화살표를 눌렀을 때의 기준으로 사용됨
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
		
		
		// 이전 블럭 활성화 여부 (1Block의 1번째 이전 비활성화)
		if(curBlock>1) {
			this.pre=true;
		}
		// 다음 블럭 활성화 여부 (마지막 Block의 마지막 이후 비활성화)
		if(curBlock<totalBlock) {
			this.next=true;
		}
		
		
		// 현재 블럭이 마지막 블럭일 때 lastNum을 totalPage숫자로 대입
		// 마지막 블럭까지만 보여지기 if(curBlock==totalBlock) -> false
		if(!this.next) {	// false
			this.lastNum=totalPage;
		}
	}
	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getSearch() {
		if(this.search==null) {
			// search가 null(검색X)일 때 LIKE '%%'를 실행하기 위해 ""로 빈칸을 제공
			this.search="";
		}
		
		return "%"+search+"%";
	}


	public void setSearch(String search) {
		this.search = search;
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

	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}


	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
}
