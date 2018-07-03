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
		$(location).attr("href","check.do?email="+$("#email").val());
	});
});
</script>
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
가입할 이메일을 입력하시오 : <input type="text" id="email">
<button id="btn">이메일 인증</button>
</body>
</html>