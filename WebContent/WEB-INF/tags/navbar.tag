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
		<div class="navbar-nav ">
			<c:if test="${not empty sessionScope.authUser }">
				<a class="nav-link nav-item ${current.logout }" 
					href="logout.do" style="color:white">로그아웃</a>
				<a class="nav-link nav-item ${current.memberInfo }"
					href="${ctxPath }/memberInfo.jsp" style="color:white">회원정보</a>
				<!-- <a class="nav-link nav-item" 
					href="message.do" style="color:white">리뷰</a> -->
				<%-- <a class="nav-link nav-item ${current.changePwd }"
					href="changePwd.do">암호변경</a>
				<a class="nav-link nav-item ${current.deleteMember }"
					href="deleteMember.do">회원탈퇴</a> --%>
			</c:if>

			<c:if test="${empty sessionScope.authUser }">
				<a class="nav-link nav-item ${current.join }" href="join.do" style="color:white">회원가입</a>
				<a class="nav-link nav-item ${current.login }" href="login.do" style="color:white">로그인</a>
			</c:if>

			<c:if test="${sessionScope.authUser.select eq 'Administrator'}">
				<a class="nav-link nav-item" href="write.do" style="color:red">영화 등록</a>
			</c:if>
						
		</div>
	</div>
</nav>