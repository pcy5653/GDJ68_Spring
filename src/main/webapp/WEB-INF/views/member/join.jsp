<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>

<style>
	.f{color: red;}
	.s{color: blue;}
</style>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
<section class="container mt-5">	
	<h1 class="my-4">Join Page</h1>
	
	<form action="./join" method="post" enctype="multipart/form-data" id="frm">
	<!-- enctype으로 보내는 데이터를 분할하여 Server로 전송 -->
	<div class="mb-3">
	  <label for="id" class="form-label">ID</label>
	  <input type="text" name="id" class="form-control" id="id" placeholder="ID를 입력하세요">
	  <div id="idText"></div>
	</div>
	
	<div class="mb-3">
	  <label for="pw" class="form-label">PASSWORD</label>
	  <input type="password" name="pw" class="form-control" id="pw" placeholder="PW를 입력하세요">
	  <div id="pwText"></div>
	</div>
	<div class="mb-3">
		<label for="pw" class="form-label"> ONE MORE PASSWORD</label>
		<input type="password" name="pw2" class="form-control" id="pw2" placeholder="PW를 입력하세요">
		<div id="pwText2"></div>
	  </div>
	
	<div class="mb-3">
	  <label for="name" class="form-label">Name</label>
	  <input type="text" name="name" class="form-control" id="name" placeholder="Name을 입력하세요">
	  <div id="nameText"></div>
	</div>
	
	<div class="mb-3">
	  <label for="email" class="form-label">Email</label>
	  <input type="email" name="email" class="form-control" id="email" placeholder="Email를 입력하세요">
	   <div id="emailText"></div>
	</div>
	
	<div class="mb-3">
	  <label for="birth" class="form-label">Birth</label>
	  <input type="date" name="birth" class="form-control" id="birth">
	  <div id="birthText"></div>
	</div>
	
	<div class="mb-3">
	  <label for="pic" class="form-label">사진첨부</label>
	  <input type="file" name="pic" class="form-control" id="pic" placeholder="PW를 입력하세요">
	</div>
	
	<div class="mb-3">
		<button class="btn btn-primary" type="button" id="btn">회원가입</button>
	</div>
	
	</form>
	
	
</section>

	<script src="/resources/js/member.js"></script>
</body>
</html>