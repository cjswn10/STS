<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${title }</h2>
	<hr>
	<form action="insertBoard.do?no=${no}" method="post" enctype="multipart/form-data">
		원글 번호: ${no}<br>
		글 제목 :<input type="text" name="title" value=${ptitle }><br> 
		작성자 :<input type="text" name="writer"><br> 
		암호:<input type="password" name="pwd"><br>
		글 내용 :<br>
		<textarea rows="10" cols="60" name="content"></textarea><br> 
		파일:<input type="file" name="uploadFile"><br> 
		<input type="submit" value="등록"> 
		<input type="reset" value="취소">
	</form>
</body>
</html>