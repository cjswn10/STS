<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table {
	border-collapse: collapse;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품목록</h2><hr>
	
	<form action="listGoods.do" method="post">
		<select name="keyField">
			<option value="item">상품명</option> 
			<option value="price">가격</option> 
			<option value="qty">수량</option> 
		</select> :		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	
	<table border="1" width="60%">
		<tr>
			<td><a href="listGoods.do?sort=no">상품번호</a></td>
			<td><a href="listGoods.do?sort=item">상품명</a></td>
			<td><a href="listGoods.do?sort=price">가 격</a></td>
			<td><a href="listGoods.do?sort=qty">수 량</a></td>
		</tr>
		<c:forEach items="${list }" var="g">
			<tr>
			<td>${g.no }</td>
			<td>${g.item }</td>
			<td>${g.price }</td>
			<td>${g.qty }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>