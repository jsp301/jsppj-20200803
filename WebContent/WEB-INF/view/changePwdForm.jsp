<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" href="${ctxPath}/css/style.css" />

<title>Insert title here</title>
</head>
<body>
	<u:navbar changePwd="active" />

	<form action="changePwd.do" method="post">
	<div class="login-box">
  <h1>Change</h1>
  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" placeholder="Current Password" id = "input3" name="curPwd">
    <c:if test="${errors.curPwd }">현재 암호를 입력하세요.</c:if> 
    <c:if test="${errors.badCurPwd }">현재 암호가 일치하지 않습니다.</c:if>
  </div>
  
  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" placeholder="New Password" id = "input4" name="newPwd">
    <c:if test="${errors.newPwd }">새 암호를 입력하세요.</c:if>
  </div>

  <input type="submit" class="btn" value="Change">
</div>
</form>

</body>
</html>









