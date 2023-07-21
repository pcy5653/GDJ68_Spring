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
	<h1>Update Page</h1>
	<form action="./update" method="post">
		<input type="hidden" name="studNum" value="${dto.studNum}">
		이름<input type="text" name="studName" value="${dto.studName}"><br>
		합계 <input type="text" name="total">${dto.total}</input>
		평균<input type="text" name="avg" value="${dto.avg}"><br>
		
<!-- 		<p>
			판매가능 <input type="radio" value="1" checked name="bookSale"><br>
			판매중지 <input type="radio" value="0" name="bookSale"><br>
		</p> -->
		
		<p>
<!-- 			<select name="bookSale">
				<option value="1">판매가능</option>
				<option value="0" selected>판매중지</option>
			</select> -->	
		</p>
		
		<button type="submit">수정</button>
		<input type="submit" value="수정">
		<input type="reset" value="수정">
		<input type="button" value="수정">
	</form>
</body>
</html>