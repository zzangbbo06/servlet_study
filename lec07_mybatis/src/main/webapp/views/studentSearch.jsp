<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 찾기</title>
</head>
<body>
	<c:forEach var="s" items="${student }">
		<tr>
			<td>${s.studentNo }</td>
			<td>${s.studentName }</td>
			<td>${s.studentAge }</td>
		</tr>	
	</c:forEach>
</body>
</html>