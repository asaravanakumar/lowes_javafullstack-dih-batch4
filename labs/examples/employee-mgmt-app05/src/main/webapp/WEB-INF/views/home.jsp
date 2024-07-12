<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title>Employee Management App</title>
<spring:url value="/" var="contextPath" htmlEscape="true" />
</head>
<body>
	<h1>Welcome to Employee Management App!</h1>
	<p> Current Time: ${serverTime} </p>
	<p> <a href="login">Login</a>
</body>
</html>
