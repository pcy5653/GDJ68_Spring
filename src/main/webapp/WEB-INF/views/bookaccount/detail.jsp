<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
	<h1>Detail Page</h1>
	
	<%-- ${} --%>
	<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째글자를 소문자로 바꾼것 -->
	<!-- DB & GETTER 이름 동일 -->
		<div class="mb-3 nameLine">
		  <p class="form-label nameLabel">작성자</p>
		  <span name="id" class="form-control">${dto.id}</span>
		</div>
		<div class="mb-3">
		  <p lass="form-label">상품번호</p>
		  <span class="form-control">${dto.bookNum}</span>
		</div>
		<div class="mb-3">
		  <p lass="form-label">통장번호</p>
		  <span class="form-control">${dto.account}</span>
		</div>	
		<div class="mb-3">
		  <p lass="form-label">통장비밀번호</p>
		  <span class="form-control">${dto.accountPassword}</span>
		</div>
		<div class="mb-3">
		  <p lass="form-label">잔액</p>
		  <span class="form-control">${dto.accountBalance}</span>
		</div>
		<div class="mb-3">
		  <p lass="form-label">가입일</p>
		  <span class="form-control">${dto.accountDate}</span>
		</div>
	
	
	<c:forEach items="${dto.fileDTOs}" var="f">
		<img alt="" src="/resources/upload/bankbook/${f.fileName}">
	</c:forEach>
	
	<!-- 
	<a href="./update?bookNum=${dto.bookNum}">수정</a>
	<a href="./delete?bookNum=${dto.bookNum}">삭제</a> 
	-->



	<button id="update">수정</button>
	<!-- 2. 속성 사용 : data-**** 이라는 속성명을 통해 bookNum을 받아와 JS에서 id명.getAttributes로 불러와 삭제 -->
	<button id="del" data-delete-name="bookNum" data-delete-num="${dto.bookNum}">삭제</button>
	
	
<%-- 	
	<c:if test="${dto.bookSale eq 1}">
		<h1>판매중</h1>
	</c:if>
	<c:if test="${dto.bookSale eq 0}">
		<h1>판매종료</h1>
	</c:if>
--%>
	
	<!-- 현재 detail.jsp 위치 : /bankbook/detail.jsp 
		 실제 경로 root 기준   : /bankbook/detail.jsp
		 detail.jsp 기준	  : ..(bankbook 폴더 나가고)/resorce/js/delete.js		=> script 주소
		-->
	<script src="../resources/js/delete.js"></script>

	<!-- <script>
		// 1. 함수 사용 : js에서는 ${dto.bookNum}이 넘어가지 못하니 함수에 담아 보내준다.
		setBookNum(${dto.bookNum});
	</script> -->
</body>
</html>