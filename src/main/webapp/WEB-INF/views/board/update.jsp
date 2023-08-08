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
		<h1 class="mb-5 text-center">${board} 게시물 수정</h1>
	 
		<form action="./update" method="post" enctype="multipart/form-data">
		   <input type="hidden" name="num" value="${dto.num}">
		   <div class="mb-3">
			<label class="form-label fw-bold fs-5" for="writer">작성자</label>
			<input id="writer" type="text" name="name" value="${member.id}" class="form-control">
		 </div>
		   <div class="mb-3">
			  <label class="form-label fw-bold fs-5" for="title">TITLE</label>
			  <input id="title" type="text" name="subject" value="${dto.subject}" class="form-control">
		   </div>
		   <div class="mb-3">
			  <label class="form-label fw-bold fs-5" for="contents">CONTENTS</label>
			  <textarea id="contents" name="contents" rows="" cols="" class="form-control">${dto.contents}</textarea>
		   </div>
  
		   	<!-- 파일 -->

			<div class="mb-3">
				<button type="button"  id="add">File 추가</button>
			</div>

			<div id="fileList" class="my-5">
				
			</div>

			<div>
				<c:forEach items="${dto.fileDTOs}" var="f">
					<div class="alert alert-info" role="alert">
						${f.originalName}
					</div>
					<span class="delets" data-delete-num="${f.fileNum}">X</span>
				</c:forEach>
			</div>

			
		   <button type="submit" class="btn btn-dark">수정</button>
		</form>   
	 </section>

	 <script src="/resources/js/file.js"></script>
  
</body>
</html>