<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<p>  The time on the server is ${serverTime}. </p>

<form action="<c:url value='/logout' />" method="POST">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="submit" value="로그아웃" />
</form>

<p>
	<a href="<c:url value='/login' />">로그인 페이지로 이동하기</a>
</p>

</body>
</html>
