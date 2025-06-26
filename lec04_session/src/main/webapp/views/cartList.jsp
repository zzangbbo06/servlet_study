<%@page import="java.util.ArrayList"%>
<%@page import="com.gn.dtp.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
		List<Product> cart = (List<Product>) session.getAttribute("cart");
	%>
	
	<h2>🛒 장바구니 목록</h2>

<% if (cart != null && !cart.isEmpty()) { %>
	
	<% for (Product p : cart) { %>
		<p><%= p.getName() %> - <%= p.getPrice() %>원</p>
	<% } %>
	
<% } else { %>
	<p>장바구니가 비어 있습니다.</p>
<% } %>
</body>
</html>