<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.mborder{ 
	border: 3px solid gold;
	border-radius: 10px;
	width: 200px;
	margin : 10px;
	padding : 10px;	
}

</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function() {
	$.ajax({
		url: "listMongoMember.do",
		success: function(data) {
			
			var arr = eval("("+data+")");
			$.each(arr, function(idx, m) {

				var div = $("<div></div>");
				$(div).addClass("mborder");
				
				$.each(m, function(j, m2) {
					if(j == "name"){
						$("<h3></h3>").html(m2).appendTo(div);
					} else {
						$("<p></p>").html(m2).appendTo(div);
					}
						
				})

				$("#list").append(div);
				
				
			})
		}
		
	})
	
	$("#search").click(function() {
		$.ajax({
			url: "search.do",
			success : function(data) {
				
			}
		})
	})
})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보</h2>
	이름 : <input type="text" id="name">
	<button id="search">검색</button>
	
	<div id="list"></div>
</body>
</html>