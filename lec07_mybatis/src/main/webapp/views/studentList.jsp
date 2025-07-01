<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 목록 조회</title>
</head>
<body>
	<table border = "1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${list }">
			<!-- 화면 전환할때 사용하는 location.href  -->
				<tr onclick="location.href='/student/detail?no=${s.studentNo}'">
			<!-- 주소쪽은 붙여써주는게 좋음 no = 이렇게 말고 no= 이렇게 써야함 -->
					<td>${s.studentNo }</td>
					<td>${s.studentName }</td>
					<td>${s.studentAge }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>