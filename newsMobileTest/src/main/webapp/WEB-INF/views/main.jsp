<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
   content="with=device-width,
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
		url: "listNews.do",
		success: function(data) {
			list = eval("("+data+")");
			$.each(list, function(i, n){
				var li = $("<li></li>").appendTo("#list");
				var a = $("<a href='#detail' data-transition='slidedown'></a>").attr("idx", i);
				var title = $("<span></span>").html(n.title);
				
				$(a).append(title);
				$(li).append(a);
				
				$(a).click(function() {
					var idx = $(this).attr("idx");
					var selN = list[idx];
					$("#title").html(selN.title);
					$("#news").html(selN.content);
					
				})
				
			});
			$("#list").listview("refresh");
		}
	});
});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="home" data-role="page">
	<div data-role="header">
		<h1>오늘의 뉴스</h1>
	</div>
	
	<div data-role="content">
		<ul data-role="listview" data-inset="true" id="list">
		
		</ul>
	</div>
</div>
<div id="detail" data-role="page">	
	<div data-role="header">
		<h1>오늘의 뉴스</h1>
	</div>
	
	<div data-role="content">
		<h2 id="title"></h2>
		<div id="news"></div>
	</div>
</div>
</body>
</html>