<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>

<style>
	h1 {text-align:center;font-weight:800;}
	.container {position:relative;} 
	
	input{margin-bottom: 10px;}
	.form-label {font-size:1.5rem; font-weight:600;}
	.nameLine {display:flex; padding-top:0.5rem;}
	.nameLabel {margin-right:3rem;}
	#nName{width: 20rem;}
	.btn{
		border:var(--bs-btn-border-width) solid #9fb1df;
		background-color:#9fb1df;
		position:absolute; right:0; bottom:0;
	}
	.btn-danger{
		--bs-btn-hover-border-color: #2497fa;
		--bs-btn-hover-bg:#2497fa; 
		transition: all 0.5s cubic-bezier(0.28, -0.32, 0.58, 1.19);
		}
	#fileBtn{
		--bs-btn-hover-border-color: #2497fa;
		--bs-btn-hover-bg:#2497fa; 
		transition: all 0.5s cubic-bezier(0.28, -0.32, 0.58, 1.19);
	}
</style>

</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
	
	<section class="container mt-5">
	<h1 class="my-4">${board} Add Page</h1>
	
	<form action="./add" method="post" id="frm" enctype="multipart/form-data">
		<div class="mb-3 nameLine">
		  <label for="name" class="form-label nameLabel">작성자</label>
		  <input type="text" name="name" class="form-control" id="writer" value="${member.id}">
		</div>
		<div class="mb-3">
		  <label for="title" class="form-label">Title</label>
		  <input type="text" name="subject" class="form-control" id="subject" placeholder="제목을 작성하세요">
		</div>
		<div class="mb-3">
		  <label for="contents" class="form-label">Contents</label>
		  <textarea class="form-control" name="contents" id="contents" rows="3"></textarea>
		</div>	
		
		
		<div id="fileList" class="my-5"></div>
		
		<div class="mb-3">
			<button type="button"  id="add">File 추가</button>
		</div>
		



		<div class="my-3">
			<button type="button" class="btn btn-danger" id="btn">게시글 등록</button>
		</div>

	</form>
	</section>
	<script src="/resources/js/file.js"></script>

	<script>
		// >>>> Title 미작성 시 넘어가지 않도록 설정.
		const btn = document.getElementById("btn");
		const subject = document.getElementById("subject");
		const frm = document.getElementById("frm");

		btn.addEventListener("click", function(){
			console.log(subject.value=="");			// true
			console.log(subject.value.length == 0); // true
			if(subject.value==""){
				alert("제목은 필수 입니다.");
				// title 강제 작성
				subject.focus();
			}else {
				frm.submit();
			}
		})

	</script>
</body>
</html>