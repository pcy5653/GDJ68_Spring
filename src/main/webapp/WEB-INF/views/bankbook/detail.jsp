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
	
	<form action="./add.do" method="post">
		<div class="mb-3">
		  <label for="bookName" class="form-label">상품명</label>
		  <input type="text" name="bookName" class="form-control" id="bookName" placeholder="상품명">
		</div>
		<div class="mb-3">
		  <label for="bookContents" class="form-label">상품내용</label>
		  <textarea class="form-control" name="bookContents" id="bookContents" rows="3"></textarea>
		</div>	
		<div class="mb-3">
		  <label for="bookRate" class="form-label">이자율</label>
		  <input type="text" name="bookRate" class="form-control" id="bookRate" placeholder="이자율">
		</div>
		
		<div class="form-check">
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
		</div>

		<div class="my-3">
			<button type="submit" class="btn btn-danger">상품등록</button>
		</div>

	</form>
	</section>
</body>
</html>