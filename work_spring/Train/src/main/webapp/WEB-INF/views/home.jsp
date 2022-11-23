<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>메인</h1>
	<c:if test="${empty user }">
	<a href="${pageContext.request.contextPath}/user/regist">회원가입</a><br>
	<a href="${pageContext.request.contextPath}/user/login">로그인</a><br>
	</c:if>
	<c:if test="${not empty user }">
		<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a><br>
	</c:if>
	
	<a href="${pageContext.request.contextPath}/car/list">자동차 목록 보기</a><br>
	<a href="${pageContext.request.contextPath}/car/regist">자동차 등록</a><br>
	
	

</body>
</html>
