<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립팅</title>
</head>
<body>
	<%-- Scriptlet : 일반적인 자바 코드 --%>
	<% 
		int sum = 0;
		for(int i = 1; i <= 10; i++){
			sum += i;
		}
		out.println("총합: " + sum);	
	%>
	<%-- >System.out.println("총합: " + sum); -> 콘솔에 출력 --%> 
	<br>
	<%-- Expression : (화면에) 출력 --%>
	<%= "총합 : " + sum %>
	<br>
	<%-- Declaration: 선언 --%>
	<%! int visitCount = 0; %>
	<%
		int tempCount = 0;
		visitCount++; // 새로고침할때마다 값이 증가 -> 변수가 재선언 되지 않고 증가된 상태로 있어서 계속해서 증가
		tempCount++; // 새로고침할때마다 변수가 재선언 되어서 0에서 시작하여 1로만 증가
	%>
	<p>선언 태그: <%= visitCount %></p>
	<p>스크립틀릿: <%= tempCount %></p>
</body>
</html>