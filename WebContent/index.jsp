<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>


<!DOCTYPE html>
<html>
<title>NetFlix R</title>
<head>
<meta charset="UTF-8">
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
<c:if test="${not empty abcdefg}">
	<script>
		alert("암호가 변경되었습니다!");
	</script>
</c:if>
<title>...</title>

<style type="text/css">
	body { background-color: black;}
</style>

</head>
<body>
	<u:navbar home="active" />


	<div class="container mt-3">
		<div class="jumbotron">
			<!-- ?? 테이블로 칸 맞춰서 정렬?? -->
			<!-- <u:pre value="영화           리뷰"/> -->
			<h1 class="display-4" style="color:red">NetFlix의 모든 것</h1>
			<h2>다양한 영화, tv프로그램 정보를 만나보세요.</h2>
			
			<hr class="my-5">
			
			<!-- <h1 class="display-5">영화&nbsp;&nbsp;&nbsp;리뷰</h1>
			<a class="lead" href="write.do">새 영화</a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="lead" href="">리뷰	작성</a>
			<hr />
			<a class="btn btn-primary btn-lg" href="join.do" role="button">회원가입</a> -->
		</div>
	</div>



<!-- 	<hr color="red"/> -->
	<marquee onmouseover="stop();" onmouseout="start();" scrollamount="10" direction="left"	bgcolor="gold">
		<font size="5" color="Green"> <a href="https://www.netflix.com/kr/" style="color: black">영화 소개 </a> </font>
	</marquee>
	<marquee onmouseover="stop();" onmouseout="start();" scrollamount="10" direction="left"	bgcolor="red">
	<c:forEach var="movie" items="${mainMovie.content }">
		<font size="5"> 
		<a href="${ctxPath }/read.do?no=${movie.number}" style="color: black">${movie.title} </a>  
	</c:forEach>
	</marquee>



	<hr />
	<u:pageNoCon />
	

	
	<hr />
	<div class="container" align="center" >
	<table>
		<tr>
		<td>
		<c:forEach var="movie" items="${mainMovie.content }">
			<button onclick="location='${ctxPath }/read.do?no=${movie.number}'" style="background-color: red">
			<c:out value="No.${movie.number }" /> <br />
			<c:out value="제목: ${movie.title }" /> <br />
			<img src="/imgs/${movie.number }/${movie.fileName }" style="width: 345px; height: auto;" />
			</button> 
		</c:forEach>
		</td>
		</tr>
	</table>
	</div>
		
		

	<hr />
	<u:pageNoCon />


		
	<hr color="red"/>
	<u:footer home="active" />


	
</body>
</html>




<%-- 	<c:if test="${mainMovie.hasNoMovies() }">
			<tr>
				<td>등록된 영화가 없습니다.</td>
			</tr>
		</c:if> 
		
		<a href="read.do?no=${movie.number }">
			<c:out value="/imgs/${movie.number}/${movie.fileName }"></c:out>
		</a> 

<hr />
		<div class="container" >			
			<button onclick="location='${ctxPath }/read.do'">
				제목 : [${movieDat.movie.title }] <br />
				<img src="/imgs/5/오케이 마담.jpg" style="width: 320px; height: auto;" />
			</button>
			
			<button onclick="location='${ctxPath }/read.do'">
				제목 : [] <br />
				<img src="/imgs/2/kissing booth2.jpg" style="width: 320px; height: auto;" />
			</button>

			<button onclick="location='${ctxPath }/read.do'">
				제목 : [] <br />
				<img src="/imgs/3/반도.jpg" style="width: 320px; height: auto;" />
			</button>
			
			<button onclick="location='${ctxPath }/read.do'">
				제목 : [] <br />
				<img src="/imgs/4/강철비2.jpg" style="width: 320px; height: auto;" />
			</button>
			
			<button onclick="location='${ctxPath }/read.do'">
				제목 : [] <br />
				<img src="/imgs/3/반도.jpg" style="width: 320px; height: auto;" />
			</button>
			
			<button onclick="location='${ctxPath }/read.do'">
				제목 : [] <br />
				<img src="/imgs/4/강철비2.jpg" style="width: 320px; height: auto;" />
			</button>
			
			<button onclick="location='${ctxPath }/read.do'">
				제목 : [] <br />
				<img src="/imgs/5/오케이 마담.jpg" style="width: 320px; height: auto;" />
			</button>

		</div>
	</div>

	<h3>액션</h3>
	<hr />
	<div class="container mt-3">
		<table border="1" width="100%">
			<tr>
				<td colspan="3">
					<marquee onmouseover="stop();"
						onmouseout="start();" scrollamount="10" direction="left"
						bgcolor="gold">
						<font size="5" color="blue"> <a href="${ctxPath}/message.do">영화 소개</a> </font>
					</marquee>
				</td>
			</tr>
			<tr>
				<td>영화1</td>
				<td>영화2</td>
				<td>영화3</td>
			</tr>
			<tr>
				<td>
					<img onclick="location='${ctxPath }/read.do'" src="/imgs/2/kissing booth2.jpg" style="width: 300px; height: auto;" />
					
					<!-- 이런 방식으로 입력!! -->
					<c:if test="${not empty movieData.fileName }">
						<img src="/imgs/${movieData.movie.number }/${movieData.fileName}"/>
					</c:if></td>
					
				<td>
					<img onclick="location='${ctxPath }/read.do'" src="/imgs/3/반도.jpg" style="width: 300px; height: auto;" />
				</td>
				<td>
					<img onclick="location='${ctxPath }/read.do'" src="/imgs/4/강철비2.jpg" style="width: 300px; height: auto;" />
				</td>
			</tr>
		</table>
	</div>
	<hr />
	<h3>로맨스 코미디</h3>
	<hr />
	<div class="container mt-3">
		<table border="1" width="100%">
			<tr>
				<td>영화4</td>
				<td>영화5</td>
				<td>영화6</td>
			</tr>
			<tr>
				<td>
					<button onclick="location='${ctxPath }/read.do'">
						<img src="/imgs/2/kissing booth2.jpg" style="width: 300px; height: auto;" />
					</button>
				</td>
				<td>
					<button onclick="location='${ctxPath }/read.do'">
						<img src="/imgs/5/오케이 마담.jpg" style="width: 300px; height: auto;" />
					</button>
				</td>
				<td>
					<button onclick="location='${ctxPath }/read.do'">
						<img src="/imgs/2/kissing booth2.jpg" style="width: 300px; height: auto;" />
					</button>
				</td>
			</tr>
		</table>
		<div class="container">
			<div>제목 : []</div>
			<div>평점 : []점</div>
		</div> --%>



