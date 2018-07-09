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
	<h2>주문정보 검색</h2>
	<hr>
	<form action="listBook.do" method="post">
		고객명 : <input type="text" name="name"> <input type="submit"
			value="검색">
	</form>
	<hr>
	<table width="80%">
		<tr>
			<td>책제목</td>
			<td>출판사</td>
			<td>가격</td>
			<td>판매이익금</td>
			<td>주문일</td>
			<td>주소</td>
			<td>전화</td>
		</tr>
		<c:if test="${not empty name}">
			<c:forEach items="${list }" var="i">
				<tr>
					<td>${i.bookname }</td>
					<td>${i.publisher }</td>
					<td>${i.price }</td>
					<td>${i.profit }</td>
					<td>${i.orderdate }</td>
					<td>${i.address }</td>
					<td>${i.phone }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>