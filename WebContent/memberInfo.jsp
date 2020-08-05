<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@400;700;800&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<u:navbar memberInfo="active" />
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">회원정보</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>아이디</td>
				<td>${sessionScope.authUser.id }</td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>이름</td>
				<td>${sessionScope.authUser.name }</td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td>성별</td>
				<td>${sessionScope.authUser.gender }</td>
			</tr>
			<tr>
				<th scope="row">4</th>
				<td>이메일</td>
				<td>${sessionScope.authUser.email }</td>
			</tr>
		</tbody>
	</table>
	<form action="changePwd.do">
		<input type="submit" value="암호변경" />
	</form>
	<form action="deleteMember.do">
		<input type="submit" value="회원탈퇴" />
	</form>
</body>
</html>