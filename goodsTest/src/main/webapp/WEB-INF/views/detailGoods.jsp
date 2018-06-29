<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function pro(url) {
		re = confirm("정말로 삭제하시겠습니까?");
		if(re) {
			location.href = url;
		}
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
상품번호 : ${g.no }<br>
상품명 : ${g.item }<br>
가 격 : ${g.price }<br>
수 량 : ${g.qty }<br>
이미지 : <img src="resources/upload/${g.fname }"><br>
<a href="updateGoods.do?no=${g.no }">수정</a>
<a href="#" onclick="pro('deleteGoods.do?no=${g.no }')">삭제</a>
</body>
</html>