<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!-- 코어태그, 함수태그 -->
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
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<title>회원 가입 신청</title>
</head>
<body>
	
	<u:navbar join="active" />

<form action="join.do" method="post">
	<div class="login-box">
  <h1>Join</h1>
  <div class="textbox">
    <i class="fas fa-user"></i>
    <input type="text" placeholder="UserID" id = "input1" name = "id" value="${param.id }">
    <c:if test="${errors.id }">ID를 입력하세요.</c:if>
	<c:if test="${errors.duplicateId }">이미 사용중인 아이디입니다.</c:if>
  </div>
  <div class="textbox">
    <i class="fas fa-user"></i>
    <input type="text" placeholder="UserName" id = "input2" name = "name" value="${param.name }">
    <c:if test="${errors.name }">이름을 입력하세요.</c:if>
  </div>
	<div class="btn-group btn-group-toggle" data-toggle="buttons">
				<label for="gender"></label> &nbsp;&nbsp;
				<label class="btn btn-secondary active"> <input type="radio"
					name="gender" id="option1" value="female" checked>Female
				</label> <label class="btn btn-secondary"> <input type="radio"
					name="gender" id="option2" value="male">Male
				</label> 
			</div>
  <div class="textbox">
    <i class="fa fa-envelope"></i>
    <input type="text" placeholder="UserEmail" id = "input2" name = "email" value="${param.email }">
    <c:if test="${errors.name }">이메일을 입력하세요.</c:if>
  </div>
  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" placeholder="Password" id = "input3" name="password" required>
  </div>
  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" placeholder="Password" id = "input4" name="confirmPassword" required>
    <c:if test="${errors.confirmPassword }">확인을 입력하세요.</c:if> 
    <c:if test="${errors.notMatch }">암호와 확인이 일치하지 않습니다.</c:if>
  </div>

  <input type="submit" class="btn" value="Sign in">
  <input class="btn btn-warning" type="button" value="취소" onclick="history.go(-1)" />
</div>
</form>
</body>
</html>
