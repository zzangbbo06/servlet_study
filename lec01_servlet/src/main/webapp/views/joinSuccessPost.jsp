<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>반가워요 <%= request.getAttribute("id") %>님</h1>
	<h2>비밀번호가 <%= request.getAttribute("pw") %>이시네요~</h2>
	<a href='/'>홈페이지로 이동</a>
</body>
</html>