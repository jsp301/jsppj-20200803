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

<title>회원 정보 수정</title>
</head>
<body>
	<u:navbar changeMemInfo="active" />

	<hr />

	<form action="changeMemInfo.do" method="post">
	
	<h1>회원 정보 변경</h1>
	<hr />
	<table class="table table-striped table-dark">
	<tr>
		<th width="15%">이름: <br /></th>
		<td>${sessionScope.authUser.name }</td>
	</tr>
	<tr>
		<th>성별: <br /></th>
		<td>${sessionScope.authUser.gender }</td>
	</tr>
	<tr>
		<th>이메일 새 주소: <br /></th>
		<td><input style="background-color: #cccccc" type="email" name="newEmail" placeholder="###@###" /></td>
	</tr>
	<tr>
		<th>암호: <br /></th>
		<td>
		<input style="background-color: #cccccc" type="password" name="curPwd" placeholder="암호를 입력하세요" />
		<c:if test="${errors.curPwd }">현재 암호를 입력하세요.</c:if> 
    	<c:if test="${errors.badCurPwd }">현재 암호가 일치하지 않습니다.</c:if>
    	</td>
	</tr>
	<tr>
		<th>새 암호: <br /></th>
		<td>
		<input style="background-color: #cccccc" type="password" name="newPwd" placeholder="새로운 암호를 입력하세요"/>
		</td>
	</tr>
	</table>
	<input type="submit" value="변경신청" />

	<button onclick="location='${ctxPath }/memberInfo.jsp'" >취소</button>
	
	

	</form>
</body>
</html>











