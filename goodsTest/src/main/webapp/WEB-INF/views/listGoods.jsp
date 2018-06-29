<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function() {
	//상품등록, 수정, 삭제 완료후 성공하거나 실패하거나
	//적합한 메세지를 가지고 list로 오도록 합니다.
	//단 메세지를 3초후에 사라지게 합니다.
	setTimeout(function() {
		$("#show_msg").html("");
		
	}, 3000);
		
})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="show_msg"><h2><font color="gold">${msg }</font></h2></div>
<form action="listGoods.do" method="post">
	<select name="keyField">
		<option value="no">상품번호</option>
		<option value="item">상품명</option>
		<option value="price">가격</option>
	</select>
	상품명 : <input type="text" name="keyword">
	<input type="submit" value="검색">
</form>

<table border=1>
	<tr>
		<td>상품번호</td>
		<td>상품명</td>
		<td>가 격</td>
		<td>수 량</td>
		<td>이미지</td>
	</tr>
	<c:forEach var="g" items="${list }">
		<tr>
			<td>${g.no }</td>
			<td><a href="detailGoods.do?no=${g.no }">${g.item }</a></td>
			<td>${g.price }</td>
			<td>${g.qty }</td>
			<td><img src="resources/upload/${g.fname }" width="100" height="100"></td>
		</tr>	
	</c:forEach>
</table>

<a href="insertGoods.do">상품등록</a>
</body>
</html>