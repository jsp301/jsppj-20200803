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

<title>Movie add</title>
</head>
<body>

<u:navbar home="active" />

<hr color="red" />

<div class="container">
<form action="write.do" method="post" enctype="multipart/form-data">
	 <div class="form-group">
	  <label>제목:</label>
	  <input type="text" name="title" value="${param.title }" class="form-control" placeholder="ex)테넷" />
	 </div>
	 <div class="form-group">
	  <label>감독:</label>
	  <input type="text" name="director" value="${param.director }" class="form-control" placeholder="ex)크리스토퍼 놀란" />
	 </div>
	 <div class="form-group">
	  <label>장르:</label>
	  <select name="genre" class="form-control">
		<option value="romance">로맨스/멜로</option>
		<option value="Sci-fi">SF/판타지</option>
		<option value="thriller">공포/스릴러</option>
		<option value="drama">드라마</option>
		<option value="action">액션</option>
		<option value="comedy">코미디</option>
	  </select>
	</div>
	<div class="form-group">
	  <label>개봉일:</label>
	  <input type="text" name="releaseDate" value="${param.releaseDate }" class="form-control" 
	  placeholder="ex) 2020-12-25 형식" />
	</div>
	<div class="form-group">
	  <label>내용:</label>
	  <textarea name="story" class="form-control"  rows="3" placeholder="내용을 입력하세요"></textarea>
	</div>
	<hr color="red"/>
	<div class="form-group">
	  <label>사진 등록:</label>
	  <input type="file" name="file1" accept="image/*"/>
	</div>

	<hr color="red"/>
	<div align="center">
	<input type="submit" value="새 영화 등록" class="btn btn-danger" />
	<input type="button" onclick="location='${ctxPath}/main.do'" value="취소" class="btn btn-danger" />
	</div>
</form>
</div>

</body>
</html>