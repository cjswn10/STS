<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#auth").click(function() {
		
		var aNum = Math.floor(Math.random() * 9000) + 1000;
		var email = $("#email").val();
		$.ajax({
			url: "authEmail.do",
			data : {aNum: aNum, email: email},
			success: function(data){
				alert("data:" + data);
				var userNum = prompt("인증번호를 입력하세요", "");
				
				var str = "인증번호가 일치합니다";
				if(userNum != aNum) {
					str = "인증번호가 일치하지 않습니다.";
				}
				
			}
		});
		
	});
	
});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertMember.do" method="post">
	아이디 : <input type="text" name="id"><br>
	이름 : <input type="text" name="name"><br>
	나이 : <input type="text" name="age"><br>
	주소 : <input type="text" name="addr"><br>
	이메일 : <input type="text" name="email" id="email">
	<input type="button" value="인증" id="auth"><br>
	<!--  <button id="auth">인증</button><br>-->
	
	<input type="submit" value="가입">
	<input type="reset" value="취소">
</form>
</body>
</html>