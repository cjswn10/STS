<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상세보기</h2>
<hr>
원글 번호: ${b.b_ref}<br>
게시물 번호 : ${b.no}<br>
제목 : ${b.title}<br>
작성자 : ${b.writer}<br>
작성일 : ${b.regdate}<br>
조회수 : ${b.hit }<br>
내용 <br><textarea rows="10" cols="60" readonly="readonly">${b.content }</textarea><br>
첨부파일 : ${b.fname}<br>
ip주소 : ${b.ip }<br>

<a href="insertBoard.do?no=${b.no }">답글</a>&nbsp;&nbsp;
<a href="updateBoard.do?no=${b.no }">수정</a>&nbsp;&nbsp;
<a href="deleteBoard.do?no=${b.no }">삭제</a>
</body>
</html>