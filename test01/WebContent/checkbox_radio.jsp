<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
		content="width=device-width,
		initial-scale=1.0,
		maximum-scale=1.0,
		minimum-scali=1.0,
		user-scalable=no">

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h1>Checkbox / Radio</h1>
		</div>
		
		<div data-role="content">
			<form action="#" id="joinForm" method="post">
				<div data-role="fieldcontain">
				<fieldset data-role="controlgroup" data-type="horizontal">
					<legend>Hobby:</legend>
					<input id="hobby1" type="checkbox" name="hobby"/>
					<label for="hobby1">축구</label>
					<input id="hobby2" type="checkbox" name="hobby"/>
					<label for="hobby2">농구</label>
					<input id="hobby3" type="checkbox" name="hobby"/>
					<label for="hobby3">야구</label>
				</fieldset>
				</div>
				
				<div data-role="fieldcontain">
				<fieldset data-role="controlgroup">
					<legend>Hobby:</legend>
					<input id="hobby1" type="checkbox" name="hobby"/>
					<label for="hobby1">축구</label>
					<input id="hobby2" type="checkbox" name="hobby"/>
					<label for="hobby2">농구</label>
					<input id="hobby3" type="checkbox" name="hobby"/>
					<label for="hobby3">야구</label>
				</fieldset>
				</div>
				
				<div data-role="fieldcontain">
				<fieldset data-role="controlgroup" data-type="horizontal">
					<legend>Job:</legend>
					<input id="radio1" type="radio" name="job"/>
					<label for="radio1">개발자</label>
					<input id="radio2" type="radio" name="job" checked="checked"/>
					<label for="radio2">디자이너</label>

				</fieldset>
				</div>
			</form>
		</div>
	</div>
</body>
</html>