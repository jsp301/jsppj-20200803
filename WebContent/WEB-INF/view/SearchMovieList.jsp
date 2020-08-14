<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>영화 검색 리스트</title>
</head>
<body>
<h4>영화 리스트</h4>
<table border="1" style="width: 100%">
	<tr>
		<td>movieId</td>
		<td>title</td>
		<td>director</td>
		<td>genre</td>
	</tr>
	
	<tr>
	<c:forEach var="movie" items="${SearchMovie.content }">
		<td>${movie.movieId }</td>
		<td><a href="read.do?no=${movie.movieId}">${movie.movieTitle }</a> </td>
		<td>${movie.movieDirector }</td>
		<td>${movie.movieGenre }</td>
	</c:forEach>
	</tr>
</table>

</body>
</html>