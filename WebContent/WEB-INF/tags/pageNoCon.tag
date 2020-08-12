<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag dynamic-attributes="current"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container" align="center">
	<table>
	
	<c:if test="${mainMovie.hasNoMovies() }">
	<tr>
		<td>등록된 영화가 없습니다.</td>
	</tr>
	</c:if>
	
	<c:if test="${mainMovie.hasMovies() }">
		<tr>
			<td>
				<c:if test="${mainMovie.startPage > 5}">
				<a href="main.do?pageNo=${mainMovie.startPage - 5}" style="color: red">[이전]</a>
				</c:if>
				
				<c:forEach var="pNo" begin="${mainMovie.startPage}" end="${mainMovie.endPage }">
					<a href="main.do?pageNo=${pNo}" style="color: white">[${pNo}]</a> 
				</c:forEach>
				<c:if test="${mainMovie.endPage < mainMovie.totalPages}">
					<a href="main.do?pageNo=${mainMovie.startPage + 5}" style="color: red">[다음]</a>
				</c:if>
			</td>
		</tr>
	</c:if>
		
	</table>
	</div>