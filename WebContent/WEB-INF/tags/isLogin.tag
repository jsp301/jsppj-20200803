<%@ tag language="java" body-content="scriptless" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<c:if test="${not empty sessoinScope.authUser }">
	<jsp:doBody />
</c:if>
