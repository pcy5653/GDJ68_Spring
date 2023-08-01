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
	<h1>${board} Update Page</h1>
	<form action="./update" method="post">
		<input type="hidden" name="num" value="${dto.num}">
		Title<input type="text" name="subject" value="${dto.subject}"><br>
		내용 <textarea rows="" cols="" name="contents">${dto.contents}</textarea>
		
		
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