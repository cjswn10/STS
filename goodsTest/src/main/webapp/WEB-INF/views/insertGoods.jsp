<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 등록</h2><hr>
<form action="insertGoods.do" method="post" enctype="multipart/form-data">
상품번호 : <input type="text" name="no"><br>
상품명 : <input type="text" name="item"><br>
가 격 : <input type="text" name="price"><br>
수 량 : <input type="text" name="qty"><br>
이미지 : <input type="file" name="uploadFile"><br>
<input type="submit" value="등록">
<input type="reset" value="취소">
</form>
</body>
</html>