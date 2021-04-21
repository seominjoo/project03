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
<c:if test="${empty username}">
	<form action="<c:url value='/login' />" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		아이디 : <input type="text" name="username" /> <br>
		패스워드 : <input type="password" name="password" /> <br>
		<input type="submit" value="로그인" />
		<c:if test="${param.error != null}">
			아이디와 비밀번호가 일치하지 않습니다.
		</c:if>
		<c:if test="${param.logout != null}">
			로그아웃 성공!
		</c:if>
	</form>
</c:if>
<c:if test="${not empty username}">
	로그인한 상태입니다.
	<form action="<c:url value='/logout' />" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="로그아웃" />
	</form>
</c:if>
</body>
</html>