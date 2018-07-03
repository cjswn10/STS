<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	var countdown = setInterval(function(){
		if($("#s").html()==0 && $("#m").html()!=0){
			$("#s").html(59);
			$("#m").html(eval($("#m").html())-1);
		}else if($("#s").html()>0 && $("#s").html()<60){
			$("#s").html(eval($("#s").html())-1);
		}else if($("#s").html()==0 && $("#m").html()==0){
			alert("시간이 초과되었습니다. 다시인증받아주십시오.");
			$("#random").val("");
			$(location).attr("href","start.jsp");
		}
	},1000);
	
	$("#btn").click(function(){
		if($("#random").val()==$("#num").val()){
			alert("인증이 완료되었습니다.");	
			clearInterval(countdown);
			$(location).attr("href","insert.do?email="+$("#email").val());
		}else{
			$("#num").val();
			alert("틀린 번호입니다.");
		}
	});
});
</script>
<title>Insert title here</title>
</head>
<body>
<input type="hidden" id="random" value="${random }">
<input type="hidden" id="email" value="${email }">
<input type="text" id="num"><button id="btn">인증</button>
<span id="m">3</span>분<span id="s">0</span>초
<div id="r"></div>
</body>
</html>