<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 연습하기</title>
</head>
<body>
	<form action="/saveNick" method = "post">
		1. 닉네임 입력 <input type = "text" name = "user_nick">
		<button type = "submit">저장</button>
	</form>
	<form action="/removeNick" method = "post">
		2. 닉네임 삭제 <button type = "submit">삭제</button>
	</form>
</body>
</html>