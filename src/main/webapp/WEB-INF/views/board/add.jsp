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
	h1 {text-align:center;font-weight:800;}
	.container {position:relative;} 
	
	.form-label {font-size:1.5rem; font-weight:600;}
	.nameLine {display:flex; padding-top:0.5rem;}
	.nameLabel {margin-right:3rem;}
	#nName{width: 20rem;}
	.btn{
		border:var(--bs-btn-border-width) solid #9fb1df;
		background-color:#9fb1df;
		position:absolute; right:0; bottom=0;
	}
	.btn-danger{
		--bs-btn-hover-border-color: #2497fa;
		--bs-btn-hover-bg:#2497fa; 
		transition: all 0.5s cubic-bezier(0.28, -0.32, 0.58, 1.19);
		}
</style>

</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
	
	<section class="container mt-5">
	<h1 class="my-4">Add Page</h1>
	
	<form action="./add" method="post">
		<div class="mb-3 nameLine">
		  <label for="noticeName" class="form-label nameLabel">작성자</label>
		  <input type="text" name="noticeName" class="form-control" id="noticeName" value="">
		</div>
		<div class="mb-3">
		  <label for="noticeTitle" class="form-label">Title</label>
		  <input type="text" name="noticeTitle" class="form-control" id="noticeTitle" placeholder="제목을 작성하세요">
		</div>
		<div class="mb-3">
		  <label for="noticeContents" class="form-label">Contents</label>
		  <textarea class="form-control" name="noticeContents" id="noticeContents" rows="3"></textarea>
		</div>	
		
		


		<div class="my-3">
			<button type="submit" class="btn btn-danger">게시글 등록</button>
		</div>

	</form>
	</section>
</body>
</html>