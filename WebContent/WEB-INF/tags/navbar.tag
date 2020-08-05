<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag dynamic-attributes="current"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
	<a class="navbar-brand" href="${ctxPath }/netFlix/index.jsp">NETFLIX</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav ">
			<c:if test="${not empty sessionScope.authUser }">
				<a class="nav-link nav-item ${current.logout }" href="logout.do">로그아웃</a>
				<a class="nav-link nav-item ${current.memberInfo }"
					href="${ctxPath }/netFlix/memberInfo.jsp">회원정보</a>
				<%-- <a class="nav-link nav-item ${current.changePwd }"
					href="changePwd.do">암호변경</a>
				<a class="nav-link nav-item ${current.deleteMember }"
					href="deleteMember.do">회원탈퇴</a> --%>
			</c:if>

			<c:if test="${empty sessionScope.authUser }">
				<a class="nav-link nav-item ${current.join }" href="join.do">회원가입</a>
				<a class="nav-link nav-item ${current.login }" href="login.do">로그인</a>
			</c:if>

		</div>
	</div>
</nav>