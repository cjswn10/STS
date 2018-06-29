<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 목록</h2>
	<table>
		<tr>
			<td>아이디</td>
			<td>이	름</td>
			<td>나	이</td>
			<td>번	호</td>
		</tr>
		<c:forEach items="${list }" var="m">
			<tr>
				<td>${m.id }</td>
				<td>${m.name }</td>
				<td>${m.age }</td>
				<td>${m.addr }</td>
			</tr>
		
		</c:forEach>
	</table>
	<a href="insertMember.do">회원등록</a>
</body>
</html>