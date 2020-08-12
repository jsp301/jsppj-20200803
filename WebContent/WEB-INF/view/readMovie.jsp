<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>${Movie.title}게시판</title>
</head>
<body>
<!-- 8.0 -->
	<u:navbar home="active" />

	<table border="1" width="100%">
		<tr>
			<td width="10%">번호</td>
			<td>${movieData.movie.number }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><c:out value="${movieData.movie.title }" /></td>
		</tr>
		<tr>
			<td>감독</td>
			<td><c:out value="${movieData.movie.director }" /></td>
		</tr>
		<tr>
			<td>장르</td>
			<td><c:out value="${movieData.movie.movieGenre }" /></td>
		</tr>
		<tr>
			<td>개봉일</td>
			<td><c:out value="${movieData.movie.releaseDate }" /></td>
			<!-- pre-wrap : 작성한데로 화면 출력하게 한다.(script공격으로부터 보호위함) 
	<td style="white-space: pre-wrap;"> <u:pre value="${articleData.content }" /> </td>
	<td><u:pre value="${articleData.content }" /></td> -->
		</tr>
		<tr>
	<	<td>점수</td>
		<td>${avgscore}</td> 
		</tr>
			
		<tr>
			<td colspan="2"><c:set var="pageNo"
					value="${empty param.pageNo ? '1' : param.pageNo }" /> <a
				href="${ctxPath }/main.do">[목록]</a> <!--  
		<c:if test="${authUser.id == articleData.article.writer.id }">
		<a href="modify.do?no=${movieData.movie.number }">[게시글 수정]</a>
		<a href="delete.do?no=${movieData.movie.number }">[게시글 삭제]</a>		
		</c:if>
		--></td>
		</tr>
	</table>

	<div id="content">
		<table boeder="1">

			<c:if test="${sessionScope.authUser.id != null }">
				<form action="message.do" method="post">
					<input type="hidden" name="movieId"
						value="${movieData.movie.number }" /> <input type="hidden"
						name="userId" value="${sessionScope.authUser.id }" />
					<td>
						<div>${sessionScope.authUser.id }</div>
					</td>
					<td>
						<div>
							<input type="number" min="0" max="10" name="score" />
						</div>
					</td>
					<td>
						<div>
							<input type="text" name="content" />
						</div>
					</td>

					<td>
						<div>
							<input type="submit" value="NETFLIX" />
						</div>
					</td>
				</form>
			</c:if>
		</table>
	</div>
	<div class="container">
		<div class="container my-3  shadow p-3">

			<c:forEach var="message" items="${list.messageList }">
				<c:if test="${movieData.movie.number eq message.movId}">
					<div class="media border p-3">
						<div class="media-body">

							<h5 class="mt-0">${message.uId }</h5>
							SCORE : ${message.score } REVIEW : ${message.content }

						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>

		<div class="container my-3 p-3">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<c:forEach begin="1" end="${list.pageTotalCount }" var="i">
						<li class="page-item"><a class="page-link"
							href="read.do?no=${movieData.movie.number }&page=${i }">${i }</a></li>
					</c:forEach>

				</ul>
			</nav>
		</div>

	</div>


</body>
</html>