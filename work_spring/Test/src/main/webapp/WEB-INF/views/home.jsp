<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>차량 전체 조회</h1>
	<a href="${pageContext.request.contextPath}/car/list">차량 전체 조회</a>
	<a href="${pageContext.request.contextPath}/car/goRegist">등록하러 가기</a>
</body>
</html>
