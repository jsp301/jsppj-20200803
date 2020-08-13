<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<style type="text/css">
	body {
		background-color: black;
		color: white;
	}
	
	#td1 {
		text-align: center;
		align-content: center;
		align-items: center;
	}
</style>

<title>${Movie.title}게시판</title>
</head>
<body>

	<u:navbar home="active" />
	
	<hr color="red" />

	<table border="1" width="100%">

		<tr>
			<td rowspan="7" width="20%" id="td1">
				<img src="/imgs/${movieData.movie.number }/${movieData.movie.fileName }"
				style="width: 300px; height: auto;" /></td>
			<td width="8%" id="td1">번호</td>
			<td id="td1">${movieData.movie.number }</td>
			<td id="td1">점수</td>
		</tr>
		<tr>
			<td id="td1">제목</td>
			<td id="td1"><c:out value=" ${movieData.movie.title }" /></td>
			<td rowspan="4" id="td1">
				<c:if test="${avgscore >= 4}">
					<img src="${ctxPath }/css/apple.png" alt="">
				</c:if> <c:if test="${avgscore < 4 && avgscore>0}">
					<img src="${ctxPath }/css/rottenapple.png" alt="">
				</c:if> <c:if test="${avgscore == 0}">
					<c:out value="리뷰가 입력되지 않았습니다."></c:out>
				</c:if>
				
				<div class="container" style="width: 500px">
				<div class="progress">
					<div class="progress-bar progress-bar-striped bg-danger" role="progressbar" 
					style="width: ${avgscore/6*100}%"
					aria-valuenow="${avgscore}" aria-valuemin="0" aria-valuemax="6"></div>
				</div>
				</div>
					
			</td>
		</tr>
		<tr>
			<td id="td1">감독</td>
			<td id="td1"><c:out value=" ${movieData.movie.director }" /></td>
		</tr>
		<tr>
			<td id="td1">장르</td>
			<td id="td1"><c:out value=" ${movieData.movie.movieGenre }" /></td>
		</tr>
		<tr>
			<td id="td1">개봉일</td>
			<td id="td1"><c:out value=" ${movieData.movie.releaseDate }" /></td>
			<!-- pre-wrap : 작성한데로 화면 출력하게 한다.(script공격으로부터 보호위함) 
	<td style="white-space: pre-wrap;"> <u:pre value="${articleData.content }" /> </td>
	<td><u:pre value="${articleData.content }" /></td> -->

		</tr>
<%-- 		<tr>

			<td id="td1">점수</td>
			<td><c:if test="${avgscore >= 4}">
					<img src="${ctxPath }/css/apple.png" alt="">
				</c:if> <c:if test="${avgscore < 4 && avgscore>0}">
					<img src="${ctxPath }/css/rottenapple.png" alt="">
				</c:if> <c:if test="${avgscore == 0}">
					<c:out value="리뷰가 입력되지 않았습니다."></c:out>
				</c:if></td>
		</tr> --%>

		<tr>
			<td id="td1">내용</td>
			<td id="td1" colspan="2"><c:out value=" ${movieData.movie.story }" /></td>
		</tr>
	</table>




	<hr color="red" class="my-5" />

	<div id="content" class="input-group mb-3">
		<div class="input-group-prepend">
			<table border="" style="color: white; border-color: black; background-color: black; border-radius: 10px;">
				<c:if test="${sessionScope.authUser.id != null }">
					<form action="message.do" method="post">
						<input type="hidden" name="movieId"	value="${movieData.movie.number }" /> 
						<input type="hidden" name="userId" value="${sessionScope.authUser.id }" />
							
							<td>
							<div style="font-size: 20px" class="btn btn-outline-secondary">
								${sessionScope.authUser.id }</div>
							</td>
							
							<td> : </td>
						
							<td>
								<select name="score" class="btn btn-danger dropdown-toggle">
									<option value="0">점수 선택</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
								</select>
							</td>
						
							<td>
								<input type="text" class="form-control" name="content" placeholder="후기를 남겨주세요." />
							</td>
						
							<td>
								<input type="submit" value="등록" class="btn btn-outline-secondary" />
							</td>
					</form>
				</c:if>
			</table>
		</div>
	</div>










	<div class="container">
		<div class="container my-3  shadow p-3">

			<c:forEach var="message" items="${list.messageList }">
				<c:if test="${movieData.movie.number eq message.movId}">
					<div class="media border p-3">
						<div class="media-body">

							<h5 class="mt-0">${message.uId }</h5>
							SCORE : ${message.score } REVIEW : ${message.content }
				<div style="float: right;">
				<c:if test="${sessionScope.authUser.id eq message.uId }">
					<form action="deletereply.do" method="post">
						<input type="hidden" value="${message.contentId }" name="contentId" />
						<input type="hidden" value="${movieData.movie.number }" name="movieId" />
						<input type="submit" value="삭제" />
					</form>
				</c:if>
				</div>
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