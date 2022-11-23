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
	<h1>자동차 목록 조회</h1>
	<table class="table table-striped">
    <thead>
      <tr>
        <th>자동차 번호</th>
        <th>자동차 모델</th>
        <th>자동차 가격</th>
        <th>자동차 브랜드</th>
      </tr>
    </thead>
    <tbody>
		<c:forEach items="${list}" var="car">
			<tr onclick = "location.href='/train/car/detail?number=${car.number}'">
				<td>${car.number }</td>
				<td>${car.model }</td>
				<td>${car.price }</td>
				<td>${car.brand }</td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
  <a href="${pageContext.request.contextPath}">메인화면으로</a><br>
</body>
</html>