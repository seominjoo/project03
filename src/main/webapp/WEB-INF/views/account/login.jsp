<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty sessionScope.login}">
	<form action="" method="POST">
		아이디 : <input type="text" name="name" /> <br>
		패스워드 : <input type="password" name="password" /> <br>
		<input type="submit" value="로그인" />
	</form>
</c:if>
<c:if test="${not empty sessionScope.login}">
	<form action="logout" method="POST">
		<input type="submit" value="로그아웃" />
	</form>
</c:if>
	
</body>
</html>