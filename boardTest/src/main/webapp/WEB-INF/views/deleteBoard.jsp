<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="deleteBoard.do" method="post">
게시물 번호 : ${b.no }	<input type="hidden" name="no" value=${b.no }><br>
비밀번호 : <input type="password" name="pwd"><br>
<input type="submit" value="삭제">
<input type="reset" value="취소">
</form>
</body>
</html>