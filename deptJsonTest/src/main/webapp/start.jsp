<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function() {
	/*
	$.ajax("listDept.do", {
		success: function(data) {
			var list = eval("(" + data + ")");
			$.each(list, function(i, d) {
				var tr = $("<tr></tr>").appendTo($("#tb"));
				var td1 = $("<td></td>").html(d.dno);
				var td2 = $("<td></td>").html(d.dname);
				var td3 = $("<td></td>").html(d.dloc);
				
				tr.append(td1, td2, td3);
			});			
		}
	});
	*/
	
	$.getJSON("listDept.do", function(data) {
		$.each(data, function(i, d) {
			var tr = $("<tr></tr>").appendTo($("#tb"));
			var td1 = $("<td></td>").html(d.dno);
			var td2 = $("<td></td>").html(d.dname);
			var td3 = $("<td></td>").html(d.dloc);
			
			tr.append(td1, td2, td3);
		});		
	})
});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table id="tb" width="80%">
<tr>
	<td>부서번호</td>
	<td>부서명</td>
	<td>부서위치</td>
</tr>

</table>
</body>
</html>