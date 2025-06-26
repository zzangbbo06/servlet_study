<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/addToCart" method = "post">
		<select id="shopping_list" name = "shopping_list">
			<option value="1">키보드</option>
			<option value="2">마우스</option>
			<option value="3">모니터</option>
		</select>
		
		<button type = "submit">추가</button>
	
		<a href = "/cartList">장바구니로 이동</a>
	
	
	</form>

</body>
</html>