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
				
				var a = $("<a href='#'></a>");
				var spanTitle = $("<span></span>").html(b.title);
				var spanWriter = $("<span></span>").addClass("ui-li-count").html(b.writer);
				
				$(a).append(spanTitle, spanWriter);
				$(li).append(a);
				$("#list").append(li);
				
			})
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
		<ul data-role="listview" data-insert="true" id="list">
			<li data-role="list-divider">Title<span class="ui-li-count">Writer</span></li>
		</ul>
	</div>
	
	<div data-role="footer" data-position="fixed">연주 게시판</div>
</div>
</body>
</html>