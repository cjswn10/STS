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

<link rel="shortcut-touch-icon" href="resources/img/bit.png">
<link rel="apple-touch-icon" href="resources/img/bit.png">

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<script type="text/javascript">
$(function() {
	
	$("#submitBtn").click(function() {
		var info = $("#addForm").serialize();
		$.ajax({
			 url: "insert.do",
			 data: info,
			 success: function(data) {
				 alert(data)
			  	$("#msg").html(data);
			 }
		});
	});
	
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div data-role="page">
      <div data-role="header">
         <h1>form 테이블에 저장</h1>
      </div>


      <div data-role="content">
         <form id="addForm">
            <div data-role="fieldcontain">
               <label for="age">나이:</label>
               <input id="age" type="number" name="age" min="1" max="150">
            </div>

            <div data-role="fieldcontain">
               <label for="email">Email : </label>
               <input id="email" type="email" name="email">
            </div>

            <div data-role="fieldcontain">
               <label for="url">Url : </label>
               <input id="url" type="url" name="url">
            </div>
            
            <div data-role="fieldcontain">
               <label for="tel">Tel :</label>
               <input id="tel" type="text" name="tel">
            </div>
         </form>
         <a href="#" id="submitBtn" data-role="button" data-inline="true" data-icon="plus">추가</a>
         
         <span id="msg"></span>
      </div>
   </div>
</body>
</html>