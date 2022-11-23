<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	홈페이지  
</h1>
<c:if test="${empty userInfo}">
	<a href="${pageContext.request.contextPath}/user/login">로그인하러 가기</a>
</c:if>
<c:if test="${not empty userInfo}">
	<a href="${pageContext.request.contextPath}/user/logout">로그아웃하러 가기</a>
</c:if>

<a href="${pageContext.request.contextPath}/book/list">책 목록 조회</a>
<a href="${pageContext.request.contextPath}/book/list2">책 목록 조회-리다이렉트</a>
<a href="${pageContext.request.contextPath}/book/insert">책 등록하러 가기</a>

</body>
</html>
