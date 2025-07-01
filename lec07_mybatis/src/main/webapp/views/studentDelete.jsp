<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/student/delete" method="post">
	    <input type="hidden" name="studentNo" value="${student.studentNo }">
	    이름 : <input type="text" name="studentName" value="${student.studentName }"><br>
	    나이 : <input type="number" name="studentAge" value="${student.studentAge }"><br>
	    <input type="submit" value="삭제">
	</form>
</body>
</html>