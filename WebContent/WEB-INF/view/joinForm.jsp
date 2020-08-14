<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<style type="text/css">
body {
	background-color: black;
	color: white;
	/* 		background-image: url("${ctxPath }/css/netflixCrown.jpg") no-repeat; */
}
</style>


<script>
	$(document).ready(function() {
		$("#admin1").hide();
		$("#showAd").click(function() {
			$("#admin1").show();
		});

	});
</script>


<title>회원 가입 신청</title>
</head>
<body>

	<u:navbar join="active" />
	<hr color="red" />


	<div class="container">
		<table border="0" style="border-color: red">
			<tr>
				<td width="40%" align="left">


					<form action="join.do" method="post">
						<div class="login-box">
							<h1 style="border-bottom: 6px solid red;">Join</h1>

							<%-- <div class="form-group">
								<i class="fas fa-user-cog"></i> 
								<select name="JoinSelect" id="select1" class="form-control">
									<option name="JoinSelect" value="Customer">Customer</option>
									<c:if test="${adminPass eq '1234' }">
										<option name="JoinSelect" value="Administrator">Administrator</option>
									</c:if>
								</select>
							</div> --%>


							<div class="form-group">
								<i class="fas fa-user-cog"></i>
								<div class="form-group btn-group btn-group-toggle"	data-toggle="buttons">
									<label for="JoinSelect"></label> 
									<label class="btn btn-secondary active"> 
									<input type="radio"	name="JoinSelect" id="option1" value="Customer" checked>Customer</label> 
									<c:if test="${adminPass eq '1234' }">
									<label class="btn btn-secondary"> 
									<input type="radio"	name="JoinSelect" id="option2" value="Administrator">Administrator</label>
									</c:if>
								</div>
							</div>



							<div class="form-group">
								<i class="fas fa-user"></i> <input type="text"
									class="form-control" placeholder="UserID" id="input1" name="id"
									value="${param.id }">
								<c:if test="${errors.id }">ID를 입력하세요.</c:if>
								<c:if test="${errors.duplicateId }">이미 사용중인 아이디입니다.</c:if>
							</div>
							<div class="form-group">
								<i class="fas fa-user"></i> <input type="text"
									class="form-control" placeholder="UserName" id="input2"
									name="name" value="${param.name }">
								<c:if test="${errors.name }">이름을 입력하세요.</c:if>
							</div>
							<div class="form-group">
								<i class="fas fa-venus-mars"></i>
							<div class="btn-group btn-group-toggle" data-toggle="buttons">
								<label for="gender"></label> &nbsp;&nbsp; <label
									class="btn btn-secondary active"> <input type="radio"
									name="gender" id="option1" value="female" checked>Female
								</label> <label class="btn btn-secondary"> <input type="radio"
									name="gender" id="option2" value="male">Male
								</label>
							</div>
							</div>

							<div class="form-group">
								<i class="fa fa-envelope"></i> <input type="text"
									class="form-control" placeholder="UserEmail" id="input2"
									name="email" value="${param.email }">
								<c:if test="${errors.name }">이메일을 입력하세요.</c:if>
							</div>
							<div class="form-group">
								<i class="fas fa-lock"></i> 
                <input type="password" class="form-control" placeholder="Password" id="input3" name="password" required>
							</div>
							<div class="form-group">
								<i class="fas fa-lock"></i> 
                <input type="password" class="form-control" placeholder="Password" id="input4" name="confirmPassword" required>
								<c:if test="${errors.confirmPassword }">확인을 입력하세요.</c:if>
								<c:if test="${errors.notMatch }">암호와 확인이 일치하지 않습니다.</c:if>
							</div>

							<input type="submit" value="Sign in" class="btn btn-danger">
							<input class="btn btn-danger" type="button" value="취소" onclick="history.go(-1)" />
							<button id="showAd" class="btn btn-warning fas fa-user-cog"> </button>
						</div>
					</form>


				</td>
				<td align="right"><img src="${ctxPath }/css/netflixCrown.jpg"	alt="" /></td>
			</tr>
		</table>
	</div>


	<hr color="red" />

	<div id="admin1" class="form-group">
		<form action="admin.do" method="post">
		<i class="fas fa-lock"></i>
			<input type="password" name="password2" class="form-control" placeholder="Password" id="input5" /> 
			<input type="submit" value="Admin" class="btn btn-danger"/>
		</form>
	</div>



</body>
</html>