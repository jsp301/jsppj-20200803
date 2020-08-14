<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag dynamic-attributes="current"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-black mb-3">
	<a class="navbar-brand" href="${ctxPath }/main.do">
	<img src="${ctxPath }/css/netflixjpg.jpg" alt="" />
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav mr-auto">
			<c:if test="${not empty sessionScope.authUser }">
				<a class="nav-link nav-item ${current.logout }" 
					href="logout.do" >로그아웃</a>
				<a class="nav-link nav-item ${current.memberInfo }"
					href="${ctxPath }/memberInfo.jsp" >회원정보</a>
				<!-- <a class="nav-link nav-item" 
					href="message.do" style="color:white">리뷰</a> -->
				<%-- <a class="nav-link nav-item ${current.changePwd }"
					href="changePwd.do">암호변경</a>
				<a class="nav-link nav-item ${current.deleteMember }"
					href="deleteMember.do">회원탈퇴</a> --%>
			</c:if>

			<c:if test="${empty sessionScope.authUser }">
				<a class="nav-link nav-item ${current.join }" href="join.do" >회원가입</a>
				<a class="nav-link nav-item ${current.login }" href="login.do" >로그인</a>
			</c:if>

			<c:if test="${sessionScope.authUser.select eq 'Administrator'}">
				<a class="nav-link nav-item btn btn-outline-danger ${current.addMovie }" href="write.do" >영화 등록</a>
				<a class="nav-link nav-item btn btn-outline-danger ${current.member }" href="totalMember.do" >MEMBER</a>
			</c:if>
		</div>
		
		<!-- search -->
		<div class="navbar-nav " >
			<div><i class="fas fa-search" ></i></div>
			<div class="input-group mb-3 ">
			<form action="searchMovie.do" style="width:-10px;float:left;" >
			<table>
				<tr><!-- search value -->
					<td>
					<input class="form-control" type="text" name="sv" /> 
					</td>
					<td>
					<input class="btn btn-danger" type="submit" value="search" />
					</td>
				</tr>
			</table>				
			</form>
		</div>		
		
	</div>
</nav>