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
	<h1 class="my-4">My Page</h1>
	
	<div>
		<p>
			${member.id} : ${sessionScope.member.name}
		</p>
		<p>
			${member.email}
		</p>
		<p>
			${member.birth}
		</p>
	</div>

	<a class="btn btn-primary" href="./memberUpdate">회원수정</a>
	
</section>

</body>
</html>