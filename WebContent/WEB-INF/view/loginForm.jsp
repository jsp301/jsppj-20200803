<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
/* 		background-image: url("${ctxPath }/css/netflixCrown.jpg") no-repeat; */
}
</style>


<title>로그인</title>
</head>
<body>

	<u:navbar login="active" />
	<hr color="red" />
	
	
	<div class="container">
		<table border="0" style="border-color: red">
			<tr>
			<td width="40%" align="left">


	<form action="login.do" method="post">	
		<div class="login-box">
			<h1 style="border-bottom: 6px solid red;">Login</h1>



			<div>
				<i class="fas fa-user-cog"></i> 
				<div class="form-group btn-group btn-group-toggle" data-toggle="buttons">
					<label for="LoginSelect" ></label>
					<label	class="btn btn-secondary active"> 
					<input type="radio"	name="LoginSelect" id="option1" value="Customer" checked>Customer</label> 
					<label class="btn btn-secondary"> 
					<input type="radio"	name="LoginSelect" id="option2" value="Administrator">Administrator</label>
				</div>
			</div>



<!-- 			<div class="form-group">
				<i class="fas fa-user-cog"></i> 
				<select name="LoginSelect"	id="select1" class="form-control">
					<option name="LoginSelect" value="Customer">Customer</option>
					<option name="LoginSelect" value="Administrator">Administrator</option>
				</select>
			</div> -->



			<div class="form-group">
				<i class="fas fa-user"></i> 
				<input type="text" class="form-control" placeholder="UserID"
					id="input1" name="id" value="${param.id }">
				<small
    			 class="form-text text-muted"> <c:if test="${errors.id }">ID를 입력하세요.</c:if>
   				</small>
			</div>
			
			<div class="form-group">
				<i class="fas fa-lock"></i> 
				<input type="password" class="form-control"	placeholder="Password" id="input3" name="password" required>
				<small class="form-text text-muted"> <c:if
                  test="${errors.password }">암호를 입력하세요.</c:if> <c:if
                  test="${errors.idOrPwNotMatch }">아이디와 암호가 일치하지 않습니다.</c:if>
            	</small>
			</div>

			<input type="submit" value="login" class="btn btn-danger">
			
		</div>
	</form>
			
			
			</td>
			<td align="right"><img src="${ctxPath }/css/netflixCrown.jpg" alt="" /></td>
			</tr>
		</table>
	</div>
	
	<hr color="red" />

</body>
</html>