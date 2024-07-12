<%@ page isErrorPage="true" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <%@ taglib uri="jakarta.tags.core" prefix="c"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Login Error Page</title>
</head>

<spring:url value="/" var="contextPath" htmlEscape="true" />

<body>
<h1>
	Login Failed!  
</h1>

<p> ${exception.errorMsg != null ? exception.errorMsg : exception} </p>
<span> <a href="${pageContext.request.contextPath}/login"> Back </a></span>
</body>
</html>
