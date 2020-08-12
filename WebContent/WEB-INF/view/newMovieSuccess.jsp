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
		color: black;
	}
</style>

<title>영화 등록 성공</title>
</head>
<body>
<u:navbar home="active" />

<hr color="red"/>

<div class="jumbotron">
  <h1 class="display-4" style="font-family: Georgia; font-weight: bold;">영화가 등록 되었습니다.</h1>
  <hr class="my-5" >
<a href="${ctxPath }/main.do">[Movie List]</a>
<a href="write.do">[Movie add]</a>
</div>




</body>
</html>