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
<style type="text/css">
body {
	background-color: black;
	color: white;
}
</style>
</head>
<body>

	<u:navbar home="active" />

	<hr color="red" />
	
	<div class="container">
		<div class="row">
			<div class="col">

				<table class="table table-striped table-dark">

					<thead>
						<tr>
							<th>#</th>
							<th scope="col">KIND</th>
							<th scope="col">ID</th>
							<th scope="col">NAME</th>
							<th scope="col">GENDER</th>
							<th scope="col">EMAIL</th>
						</tr>
					</thead>


					<c:forEach var="member" items="${list1}">
						<tbody>
							<tr>
								<th scope="row"></th>
								<td>${member.userSelect }</td>
								<td>${member.userId }</td>
								<td>${member.userName }</td>
								<td>${member.userGender }</td>
								<td>${member.userEmail }</td>
							</tr>
						</tbody>
					</c:forEach>

				</table>
			</div>
		</div>
	</div>

</body>
</html>