<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="insertMember.do">회원등록</a>
	<a href="listMember.do">회원목록</a>
	<a href="listGoods.do">상품목록</a>
	
	<form action="insertMember.do" method="post">
		이름 : <input type="text" name="name">
		나이 : <input type="number" name="age">
		<input type="submit" value="등록">
	</form>
</body>
</html>