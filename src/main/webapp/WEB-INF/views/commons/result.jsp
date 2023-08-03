<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <script>
    	// 문자열로 받기 위해 '' 붙이기
    	// 1. 등록 시 메세지 여부
        alert('${message}');
    	// 2. 등록 후 Controller에서 대입한 url로 연결
		location.href="${url}";
    </script>
	

</body>
</html>