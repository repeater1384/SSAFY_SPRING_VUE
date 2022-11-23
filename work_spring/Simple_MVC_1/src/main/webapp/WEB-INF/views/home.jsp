<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>

</head>
<body>
	<h1>홈페이지</h1>
	<a href="${pageContext.request.contextPath}/book/list">책목록조회</a>
	<a href="${pageContext.request.contextPath}/book/list2">책목록조회2</a>
	<a href="${pageContext.request.contextPath}/book/list3">책목록조회3</a>
</body>
</html>
