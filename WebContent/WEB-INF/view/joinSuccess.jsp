<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<title>회원 가입 성공</title>
</head>
<body>
<u:navbar join="active" />

<hr color="red" />

<div class="jumbotron">
  <h1 class="display-4" style="font-family: Georgia; font-weight: bold;">환영합니다. <br /> ${param.name }님, 회원 가입에 성공했습니다.</h1>
</div>

<p> </p>
<br />
<br />
<br />
<br />
<p> </p>
<p> </p>
<div align="center">
	<img src="${ctxPath }/css/netflixjoin.jpg" alt="" />
	<img src="${ctxPath }/css/netflixjoin1.jpg" alt="" />
	<img src="${ctxPath }/css/netflixjoin2.JPG" alt="" />
	<img src="${ctxPath }/css/netflixjoin3.JPG" alt="" />
</div>

</body>
</html>
