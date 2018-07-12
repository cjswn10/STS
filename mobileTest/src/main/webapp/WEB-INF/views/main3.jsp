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


<title>Insert title here</title>
</head>
<body>
	<form action="insert.do" method="post">
		날짜 : <input type="date" min="2018/07/13" max="2018/08/13" step="1" value="2018/07/13"><br>
		범위 : <input type="range" min="20" max="100" step="1" value="20"><br>
		숫자 : <input type="number" min="0" max="100" step="5" value="50"><br>
		검색: <input type="search"><br>
		url: <input type="url"><br>
		메일: <input type="email"><br>
		힌트문자: <input type="text" placeholder="이름을 입력하세요"><br>
		자동포커스: <input type="text" autofocus="autofocus"><br>
		빈값 검사: <input type="text" required="required"><br>
		정규표현식 : <input type="text" pattern="(010|011)-\d{3,4}-\d{4}"><br> 
		<input type="submit" value="제출">
	</form>
</body>
</html>