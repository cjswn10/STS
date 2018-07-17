<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		url: "listBoard.do",
		success: function(data) {
			list = eval("("+data+")");
			$.each(list, function(idx, b){
				var li = $("<li></li>");
				
				var a = $("<a href='#detailView'></a>");
				
				$(a).attr("idx", idx);
				
				$(a).click(function() {
					i = $(this).attr("idx");
					var selB = list[i];
					$("#title").html(selB.title);
					$("#content").html(selB.content);
					$("#writer").html(selB.writer);
					
				});
				
				var h3Title = $("<h3></h3>");
				$(h3Title).html(b.title);
				
				var pContent = $("<p></p>");
				/*
				var c = b.content;
				if(c.length > 20) {
					pContent.html(c.substring(0, 20)+"...");
				}
				else {
					pContent.html(c);
				}
				*/
				pContent.html(b.content);
					                            
				var pWriter = $("<p class='ui-li-aside'></p>").html(b.writer);
				
				$(a).append(h3Title, pContent, pWriter);
				$(li).append(a);
				$("#list").append(li);
				
			});
			$("#list").listview("refresh");
		}
	})
})

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div data-role="page" id="mainPage">
	<div data-role="header">
		<h1>게시판</h1>
	</div>

	<div data-role="content">
		<ul data-role="listview" id="list">
			<li data-role="list-divider">Monday, July 16, 2018
			<span class="ui-li-count">yj</span></li>
		</ul>
	</div>
	
	<div data-role="footer" data-position="fixed">연주 게시판</div>
</div>

<div data-role="page" id="detailView">
	<div data-role="header">
		<h1>상세보기</h1>
		
	</div>

	<div data-role="content">
		<h3 id="title"> </h3>
		<p id="content"></p>
		<p class="ui-li-aside" id="writer"></p>
	</div>
	
	<div data-role="footer" data-position="fixed">연주 게시판</div>
</div>

</body>
</html>