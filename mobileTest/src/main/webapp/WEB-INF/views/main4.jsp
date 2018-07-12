<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<meta name="viewport"
		content="width=device-width,
		initial-scale=1.0,
		maximum-scale=1.0,
		minimum-scali=1.0,
		user-scalable=no">
<link rel="shortcut icon" href="resources/img/bit.png">
<link rel="apple-touch-icon" href="resources/img/bit.png">

<script type="text/javascript">
	
	function func1() {
		var fd = document.querySelector("#firstDiv");
		fd.innerHTML = "내용을 바꿨습니다.";
	}	
	
	function func2() {
		var arr = document.querySelectorAll("#secondDiv input:checked");
		console.log(arr.length);
		for(var i=0; i<arr.length; i++) {
			console.log(arr[i].value);
		}
		
	}

</script>

<title>Insert title here</title>
</head>
<body>

	<div id="firstDiv" style="background-color: #ffff00">DIV 내용</div>
	<form id="secondDiv">
		<input type="checkbox" name="framework" value="jquerymobile">JQuery Mobile<br>
		<input type="checkbox" name="framework" value="senchatouch1">Sencha Touch1<br>
		<input type="checkbox" name="framework" value="senchatouch2">Sencha Touch2<br>
	</form>
	
	<button onclick="func1()">div찾기</button>
	<button onclick="func2()">check찾기</button>
</body>
</html>