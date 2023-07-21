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
	
	<section class="container mt-5">
	<h1 class="my-4">Add Page</h1>
	
	<form action="./add" method="post">
		<div class="mb-3">
		  <label for="studName" class="form-label">학생명</label>
		  <input type="text" name="studName" class="form-control" id="studName" placeholder="상품명">
		</div>
		<div class="mb-3">
		  <label for="kor" class="form-label">국어</label>
		  <input type="text" name="kor" class="form-control" id="kor" placeholder="국어점수 입력">
		</div>
		<div class="mb-3">
		  <label for="eng" class="form-label">영어</label>
		  <input type="text" name="eng" class="form-control" id="eng" placeholder="영어점수 입력">
		</div>
		<div class="mb-3">
		  <label for="math" class="form-label">수학</label>
		  <input type="text" name="math" class="form-control" id="math" placeholder="수학점수 입력">
		</div>
		
<!-- 		<div class="form-check">
		  <input class="form-check-input" value="1" type="radio" name="booKSale"  id="booKSale1" checked>
		  <label class="form-check-label" for="booKSale1">
		    판매가능
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" value="0" type="radio" name="booKSale" id="booKSale2" checked>
		  <label class="form-check-label" for="booKSale2">
		   판매중단
		  </label>
		</div> -->

		<div class="my-3">
			<button type="submit" class="btn btn-danger">상품등록</button>
		</div>

	</form>
	</section>
</body>
</html>