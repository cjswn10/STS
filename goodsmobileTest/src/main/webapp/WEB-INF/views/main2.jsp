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
				
				var col = $("<div data-role='collapsible'></div>");
				//var col = $("<div></div>")
				
				var h3Item = $("<h3></h3>").html(g.item);
				var p = $("<p></p>");
				
				var img = $("<img></img>").attr({
					src: "resources/img/"+g.fname,
					width: "100"
				});
				
				var no = $("<span></span>").html(g.no);
				var price = $("<span></span>").html(g.price);
				var qty = $("<span></span>").html(g.qty);
				var br = $("<br/>");
				
				$(p).append(img, $("<br>"));
				$(p).append(no, $("<br>"));
				$(p).append(price, $("<br>"), qty);
				//, no, br, price, br, qty);
				$(col).append(h3Item, p);
				$("#list").append(col);
			});
			$("#list").collapsibleset("refresh");
		}
		
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div data-role="page">
   <div data-role="header">
      <h1>상품목록(Collapsible Block)</h1>
   </div>
   
	<div data-role="content">
		<div data-role="collapsible-set" id="list">
         <!-- 
      <div data-role="collapsible-set">
         <div data-role="collapsible">
            <h3>Collapsible</h3>
            <p>Collapsible Content Block</p>
         </div>
         <div data-role="collapsible" data-collapsed="false">
            <h3>Collapsible2</h3>
            <p>Collapsible Content Block2</p>
         </div>
         
         <div data-role="collapsible">가 있습니다.
            <h3>Collapsible3</h3>
            <p>Collapsible Content Block3</p>
         </div>
         
      </div>
          -->
		</div>
	</div>
   
   <div data-role="footer">
      연주몰
   </div>
   
</div>
</body>
</html>