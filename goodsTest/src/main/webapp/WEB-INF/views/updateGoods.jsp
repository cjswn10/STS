<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 정보 수정</h2><hr>
<form action="updateGoods.do?no=${g.no }" method="post" enctype="multipart/form-data">
상품번호 : ${g.no }<br>
상품명 : <input type="text" name="item" value="${g.item }"><br>
가 격 : <input type="text" name="price" value="${g.price }"><br>
수 량 : <input type="text" name="qty" value="${g.qty }"><br>
이미지 : ${g.fname }<img src="resources/upload/${g.fname }" width="50"><input type="file" name="uploadFile"><br>
<input type="submit" value="등록">
<input type="reset" value="취소">
</form>
</body>
</html>