<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
		content="width=device-width,
		initial-scale=1.0,
		maximum-scale=1.0,
		minimum-scale=1.0,
		user-scalable=no">

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<script type="text/javascript">
$(function() {
	var list;
	$.ajax({
		url: "listGoods.do",
		success: function(data) {
			list = eval("("+data+")");
			$.each(list, function(idx, g) {
				var id = idx + "page";
				console.log(g.item)
				/*
				var pageDiv = $("<div></div>").attr({
					"data-role" : "page",
					"class" : "page",
					"id": id
					});
				*/
				var pageDiv = $("<div data-role='page' class='page'></div>").attr({"id": id});
				var hDiv = $("<div data-role='header'></div>");
				var h2 = $("<h2></h2>").html(g.item);
				
				var cDiv = $("<div data-role='content'></div>");
				var fDiv = $("<div data-role='footer'></div>").html("연주상점");
	
				
				var p = $("<p></p>");
				var img = $("<img></img>").attr({
					src: "resources/img/"+g.fname,
					width: "100"
				});
				
				var no = $("<p></p>").html("상품번호: " + g.no);
				var item = $("<p></p>").html("상품명: " + g.item);
				var price = $("<p></p>").html("가격: " + g.price);
				var qty = $("<p></p>").html("수량: " + g.qty);
				var br = $("<br/>");
				
				$(p).append(img, no, item, price, qty);
				
				$(cDiv).append(p);
				
				$(hDiv).append(h2);
				$(pageDiv).append(hDiv, cDiv, fDiv);
				$("body").append(pageDiv);
				
				
				var nextId = "#" + (idx+1) + "page";
				if(idx == list.length-1)
					nextId = "#0page";
				
				var beforeId = "#" + (idx-1) + "page";
				if(idx == 0)
					beforeId = "#" + (list.length-1)+"page";
				
				$(pageDiv).swipeleft(function() {
					$.mobile.changePage(nextId, {transition: "slide"});
					
				});
				
				$(pageDiv).swiperight(function() {
					$.mobile.changePage(beforeId, {transition: "slide", reverse : true});
				});
				
				
			});
			$.mobile.changePage("#0page");
		}
		
	});
	//$("body").enhanceWithin();
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
<div data-role="page" class="page">
 	<div data-role="header">
 		<h2></h2>
 	</div>
 
 	<div data-role="content">
 	</div>
 	
 	<div data-role="footer">
 	</div>
</div>
	
 -->
</body>
</html>