<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>

	<c:import url="./temp/bootStrap.jsp"></c:import>


</head>
<body>
	<c:import url="./temp/header.jsp"></c:import>
	<c:if test="${not empty sessionScope.member}">
		<h1>로그인 상태</h1>
	</c:if>
	
	<c:if test="${empty member}">
		<h1>비로그인 상태</h1>
	</c:if>
</body>
</html>