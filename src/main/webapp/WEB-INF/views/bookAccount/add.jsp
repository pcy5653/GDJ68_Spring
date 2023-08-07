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
	<h1 class="my-4">상품가입 Page</h1>
	
	<form action="./add" method="post">
		<!-- 1. 받아온 bookNum을 집어넣기 -->
		<input type="hidden" name="bookNum" value="${dto.bookNum}">
		
		<!-- 2. 비밀번호는 입력하여 controller로 보내주기 --> 
		<div class="mb-3">
			<label for="pw" class="form-label">PASSWORD</label>
			<input type="password" name="accountPassword" class="form-control" id="pw" placeholder="출금 비밀번호를 입력하세요">
		</div>
		
		<div class="mb-3">
			<button type="button" id="btn" class="btn btn-primary">상품가입</button>
		</div>
	
	</form>
	
	
</section>

<script type="text/javascript">
	/* 1. 버튼을 눌렀을 때, 비밀번호 (4글자) 길이가 맞는지 확인 */
	const btn = document.getElementById("btn");
	
	btn.addEventListener("click", function(){
		if(btn.value.length == 4){
			alert("사용가능한 비밀번호 입니다.");
		}else{
			alert("비밀번호는 4글자입니다.");
		}
	})

</script>

</body>
</html>