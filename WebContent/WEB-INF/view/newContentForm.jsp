<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	ID : ${sessionScope.authUser.id }
	<br />
	<form action="message.do" method="post">
		점수 : <br /> <input type="number" min="0" max="10" name="score" /> <br />
		리뷰 : <br /> <input type="text" name="content"
			value="${param.content }" /> <br /> <input type="submit" value="등록" />

	</form>
	<hr />
	<table border="1">
		<c:forEach var="message" items="${list.messageList }">
			<tr>
				<td>메시지 번호 : ${message.id }</td>
				<td>ID :${sessionScope.authUser.id }</td>
				<td>점수 : ${message.score }</td>
				<td>메시지 : ${message.content }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>