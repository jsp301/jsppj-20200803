<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>Insert title here</title>
</head>
<body>


	<h3>button</h3>
	<hr />
	<div class="container">
		<button onclick="location='${ctxPath }/read.do'">
			제목: ${"오케이마담" } <br />
			<img src="/imgs/5/오케이 마담.jpg" style="width: 320px; height: auto;" />
		</button>

		<button onclick="location='${ctxPath }/read.do'">
			제목: ${"키싱부스2" } <br />
			<img src="/imgs/2/kissing booth2.jpg" style="width: 320px; height: auto;" />
		</button>	
		
		<button onclick="location='${ctxPath }/read.do'">
			제목: ${"강철비2" } <br />
			<img src="/imgs/4/강철비2.jpg" style="width: 320px; height: auto;" />
		</button>	
		
		<button onclick="location='${ctxPath }/read.do'">
			제목: ${"반도" } <br />
			<img src="/imgs/3/반도.jpg" style="width: 320px; height: auto;" />
		</button>	
		
		<button onclick="location='${ctxPath }/read.do'">
			제목: ${"어바웃타임" } <br />
			<img src="/imgs/25/어바웃 타임.jpg" style="width: 320px; height: auto;" />
		</button>	
		
	
	</div>
		
	<h3>img</h3>
	<hr />
	<div class="container mt-3">
		<table border="1" width="100%">
			<tr>
				<td colspan="3"><marquee onmouseover="stop();"
						onmouseout="start();" scrollamount="10" direction="left"
						bgcolor="gold">
						<font size="5" color="blue"> <a
							href="main.do">영화 소개</a>
						</font>
					</marquee></td>
			</tr>
			<tr>
				<td>영화1</td>
				<td>영화2</td>
				<td>영화3</td>
			</tr>
			<tr>
				<td><img onclick="location='${ctxPath }/read.do'"
					src="/imgs/2/kissing booth2.jpg"
					style="width: 300px; height: auto;" /> <!-- 이런 방식으로 입력!! --> <c:if
						test="${not empty movieData.fileName }">
						<img src="/imgs/${movieData.movie.number }/${movieData.fileName}" />
					</c:if></td>

				<td><img onclick="location='${ctxPath }/read.do'"
					src="/imgs/3/반도.jpg" style="width: 300px; height: auto;" /></td>
				<td><img onclick="location='${ctxPath }/read.do'"
					src="/imgs/4/강철비2.jpg" style="width: 300px; height: auto;" /></td>
			</tr>
		</table>
	</div>
	<hr />
	<h3>button in table</h3>
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
						<img src="/imgs/2/kissing booth2.jpg"
							style="width: 300px; height: auto;" />
					</button>
				</td>
				<td>
					<button onclick="location='${ctxPath }/read.do'">
						<img src="/imgs/5/오케이 마담.jpg" style="width: 300px; height: auto;" />
					</button>
				</td>
				<td>
					<button onclick="location='${ctxPath }/read.do'">
						<img src="/imgs/2/kissing booth2.jpg"
							style="width: 300px; height: auto;" />
					</button>
				</td>
			</tr>
		</table>
	
		</div>
</body>
</html>