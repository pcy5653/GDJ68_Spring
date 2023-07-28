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
	
	<!-- banner -->
	<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/resources/images/1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/resources/images/2.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/resources/images/3.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
	
	
	<c:if test="${not empty sessionScope.member}">
		<h1>로그인 상태</h1>
	</c:if>
	
	<c:if test="${empty member}">
		<h1>비로그인 상태</h1>
	</c:if>
	
	<!-- 실제 /resources/upload/member에 올라가는 경로 -->
	
</body>
</html>