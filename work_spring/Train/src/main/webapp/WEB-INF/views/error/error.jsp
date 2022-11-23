<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

</head>
<body>
	<h1>에러입니다</h1>
	<h3>${msg}</h3>
	<a href="${pageContext.request.contextPath}">메인화면으로</a><br>
</body>
</html>