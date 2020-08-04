<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!-- 코어태그, 함수태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>회원 가입 신청</title>
</head>
<body>
	<u:navbar join="active" />

	<div class="container">

		<form action="join.do" method="post">
			<div class="form-group">
				<label for="input1">아이디</label> <input type="text"
					class="form-control" name="id" id="input1" placeholder="ID를 입력하세요."
					value="${param.id }" required> <small
					class="form-text text-muted"> <c:if test="${errors.id }">ID를 입력하세요.</c:if>
					<c:if test="${errors.duplicateId }">이미 사용중인 아이디입니다.</c:if>
				</small>
			</div>

			<div class="form-group">
				<label for="input2">이름</label> <input type="text"
					class="form-control" name="name" id="input2" value="${param.name }"
					placeholder="이름을 입력하세요." required> <small
					class="form-text text-muted"> <c:if test="${errors.name }">이름을 입력하세요.</c:if>
				</small>
			</div>

			<div class="form-group">
				<label for="input2">Email</label> <input type="email"
					class="form-control" name="email" id="input2"
					value="${param.email }" placeholder="이름을 입력하세요." required>
				<small class="form-text text-muted"> <c:if
						test="${errors.name }">이메일을 입력하세요.</c:if>
				</small>
			</div>

			<div class="btn-group btn-group-toggle" data-toggle="buttons">
				<label for="gender">성별 : </label> &nbsp;&nbsp;
				<label class="btn btn-secondary active"> <input type="radio"
					name="gender" id="option1" value="female" checked>Female
				</label> <label class="btn btn-secondary"> <input type="radio"
					name="gender" id="option2" value="male">Male
				</label> 
			</div>

			<div class="form-group">
				<label for="input3">암호</label> <input type="password"
					class="form-control" name="password" id="input3" required>

				<small class="form-text text-muted"> <c:if
						test="${errors.password }">암호를 입력하세요.</c:if>
				</small>
			</div>

			<div class="form-group">
				<label for="input4">확인</label> <input type="password"
					class="form-control" name="confirmPassword" id="input4" required>

				<small class="form-text text-muted"> <c:if
						test="${errors.confirmPassword }">확인을 입력하세요.</c:if> <c:if
						test="${errors.notMatch }">암호와 확인이 일치하지 않습니다.</c:if>
				</small>
			</div>

			<input class="btn btn-primary" type="submit" value="가입" /> <input
				class="btn btn-warning" type="button" value="취소"
				onclick="history.go(-1)" />
			<!-- history.go(-1) = 이전페이지로 -->
		</form>
	</div>
</body>
</html>
