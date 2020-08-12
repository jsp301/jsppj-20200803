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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${ctxPath}/css/style.css" />
<title>로그인</title>
</head>
<body>

   <u:navbar login="active" />

   <form action="login.do" method="post">
   <div class="login-box">
  <h1>Login</h1>
  <div class="textbox">
    <i class="fas fa-user"></i>
    <input type="text" placeholder="Username" id = "input1" name = "id" value="${param.id }">
    <small
     class="form-text text-muted"> <c:if test="${errors.id }">ID를 입력하세요.</c:if>
   </small>
  </div>

  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" placeholder="Password" id = "input3" name="password">
    <small class="form-text text-muted"> <c:if
                  test="${errors.password }">암호를 입력하세요.</c:if> <c:if
                  test="${errors.idOrPwNotMatch }">아이디와 암호가 일치하지 않습니다.</c:if>
            </small>
  </div>

  <input type="submit" class="btn" value="Sign in">
</div>
</form>

${param.id }
</body>
</html>