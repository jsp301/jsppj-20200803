<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
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

<style type="text/css">
	body { 
		background-color: black; 
		color: white;
	}
</style>

<title>영화 검색 리스트</title>
</head>
<body>
	<u:navbar />
	
	<hr color="red" />
	
	<hr />
	<div class="container" align="center">
	<h3><table>
	<tr>
		<td style="color: fuchsia;">${param.sv } </td>
		<td> 에 대한 검색 결과...</td>
	</tr>
	</table></h3>
		<table border="1" style="width: 100%; text-align: center" class="table table-striped table-dark">
		<thead>
		<tr>
			<th width="10%">MOVIE_NO</th>
			<th width="30%">TITLE</th>
			<th width="30%">DIRECTOR</th>
			<th width="30%">GENRE</th>
		</tr>
		</thead>
		
		
		
		<c:forEach var="movie" items="${searchMovie.content }">
		<tbody>
		<tr>	
			<td>${movie.number }</td>
			<td><a href="read.do?no=${movie.number}" style="color: orange;">${movie.title }</a> </td>
			<td>${movie.director }</td>
			<td>${movie.movieGenre }</td>
		</tr>
		</tbody>
		</c:forEach>
		
</table>
	
	</div>

	<hr color="red" />
	<u:pageNoCon2 />


</body>
</html>