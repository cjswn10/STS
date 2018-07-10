<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
div#goodsInfo, #cart, #goodsCart, #total {
	display: inline-block;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function() {
	
	$("#goods").on("click", function() {
		$("#goods").is
		$("#goodsCart").append($("#goodsInfo");
		
	})
		
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="goodsList">
	<c:forEach items="${list }" var="g">
		<div id="goodsInfo">
			<table>
				<tr><td><input type="checkbox" id="goods" name="goods" value="${g.no}"></td></tr>
				<tr><td><img src="resources/img/${g.fname }" width="200"></td></tr>
				<tr><td>이름: ${g.item }</td></tr>
				<tr><td>가격: ${g.price }</td></tr>
				<tr><td>수량: ${g.qty }</td></tr>
			</table>
		</div>
	
	</c:forEach>
</div>

<div id="cart">
	<div id="goodsCart" width="*"></div>
	<div id="total" width="30%">총 구입 금액: <label id="totalPrice"></label></div>
</div>
<%
/*
int pageSIZE = 5;
int currentPage = 1;
int skip = (currentPage - 1) * pageSIZE;
int totalCount = 0;
int totalPage = 0;
*/
%>
</body>
</html>