<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btnRead").click(function() {
		$.ajax("listGoods.do", {
			success : function(data) {
				$("#tb").html("");
				var list = eval("(" + data +")");
				$.each(list, function(i, g) {
					var tr = $("<tr></tr>").appendTo($("#tb"));
					var td1 = $("<td></td>").html(g.item);
					var td2 = $("<td></td>").html(g.price);
					tr.append(td1, td2);
					
					$(tr).mouseover(function() {
						//var idx = $(this).attr("idx");
		                //var g = list[idx];
						
		                $("#detail").empty();
		                
		                var img = $("<img/>").attr({
		                	src: "resources/img/" + g.fname,
		                	width: "200px"
		                });
		                var br = $("<br>");
		                
		                $("#detail").append(img, br);
		                $("#detail").append("상품번호: ", g.no, $("<br>"));
		                $("#detail").append("상품명: ", g.item, $("<br>"));
		                $("#detail").append("가 격: ", g.price, $("<br>"));
		                $("#detail").append("수 량: ", g.qty, $("<br>"));
					})
				})
			}
		});
	});
});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${title }</h2>
	<hr>
	<button id="btnRead">상품목록 읽어오기</button>
	<table border="1" width="80%">
		<thead>
		<tr>
			<th>상품명</th>
			<th>가 격</th>
		</tr>
		</thead>
		<tbody id="tb">
		</tbody>
	</table>
	
	<div id="detail"></div>
	
	<a href="insertGoods.do">상품등록</a>
</body>
</html>