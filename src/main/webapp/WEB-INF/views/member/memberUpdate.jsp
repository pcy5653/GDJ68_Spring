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
	<h1 class="my-4">memberUpdate Page</h1>
	
	<form action="./memberUpdate" method="post">
	<!-- 
		1. ID는 바꾸지않는다
		2. session에 login 정보가 있으니 session을 가져온다
		   sessionScope(session)의 member(키)d의 pw를 기져온다 | sessionScope 생략가능 
	 -->
	
	<div class="mb-3">
	  <label for="pw" class="form-label">PASSWORD</label>
	  <input type="password" value="${sessionScope.member.pw}" name="pw" class="form-control" id="pw" placeholder="PW를 입력하세요">
	</div>
	
	<div class="mb-3">
	  <label for="name" class="form-label">Name</label>
	  <input type="text" value="${member.name}" name="name" class="form-control" id="name" placeholder="Name을 입력하세요">
	</div>
	
	<div class="mb-3">
	  <label for="email" class="form-label">Email</label>
	  <input type="email" value="${member.email}" name="email" class="form-control" id="email" placeholder="Email를 입력하세요">
	</div>
	
	<div class="mb-3">
	  <label for="birth" class="form-label">Birth</label>
	  <input type="date" value="${member.birth}" name="birth" class="form-control" id="birth" placeholder="PW를 입력하세요">
	</div>
	
	<div class="mb-3">
		<button class="btn btn-primary">회원수정</button>
	</div>
	
	</form>
	
	
</section>

</body>
</html>