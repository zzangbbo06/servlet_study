<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     String name = (String)request.getAttribute("name");
   	 int resultPrice = (int)request.getAttribute("resultPrice");
    %>
   	 <%-- 이런 식으로 쓸수있음 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 확인</title>
</head>
<body>
	<h1>도서 대출 내역</h1>
	<h4>[고객 정보]</h4>
	<ul>
		<li>고객명: <%= request.getAttribute("name")%></li>
		<li>전화번호: <%= request.getAttribute("phone")%></li>
		<li>이메일: <%= request.getAttribute("email")%></li>
	</ul>
	
	<h4>[대출 정보]</h4>
	<ul>
		<li>도서 제목: <%= request.getAttribute("bookName")%></li>
		<li>대출 기간: <%= request.getAttribute("borrowPeriod")%>일</li>
	</ul>
	
	<h3>대출 금액: <%= request.getAttribute("resultPrice")%>원</h3>
</body>
</html>