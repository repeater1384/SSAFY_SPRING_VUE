<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1>회원가입 화면</h1>
	<form action="${pageContext.request.contextPath}/car/regist" method = "POST" enctype="multipart/form-data">
		<label>번호</label><input type="text" name="number"><br> 
		<label>모델</label><input type="text" name="model"><br>
		<label>가격</label><input type="text" name="price"><br> 
		<label>브랜드</label><input type="text" name="brand"><br>
		<label>파일</label><input type="file" name="file"><br>
		<input type="submit" value="자동차 등록">
	</form>
</body>
</html>