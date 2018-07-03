<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		alert("서비스 준비중입니다.");
	})
});
</script>
<title>Insert title here</title>
</head>
<body>
<h1 align="center">회원가입</h1><hr>
<form action="insert.do" method="post">
ID : <input type="text" name="id"><br>
NAME : <input type="text" name="name"><br>
AGE : <input type="text" name="age"><br>
ADDR : <input type="text" name="addr"><br>
EMAIL : <input type="text" name="email" value="${email }">
<br><input type="submit" value="가입하기" id="btn">
</form>
</body>
</html>