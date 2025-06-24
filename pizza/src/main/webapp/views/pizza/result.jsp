<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역 확인</title>
</head>
<body>
	<h1>주문내역</h1>
	<h4>[고객정보]</h4>
	<ul>
		<li>성함 : <%= request.getAttribute("name") %></li>
		<li>전화번호 : <%= request.getAttribute("phone") %></li>
		<li>이메일 : <%= request.getAttribute("email") %></li>
	</ul>
	<h4>[주문정보]</h4>
	<ul>
		<li>
			사이즈 : <%= request.getAttribute("size") %>
		</li>
		<li>
			토핑 : 
			<ul>	
				<li><%= request.getAttribute("topping") %></li>
			</ul>
		</li>
	</ul>
	<h4>위와 같이 주문하셨습니다.</h4>
	<h3>총 가격 : <%= request.getAttribute("price") %>원, 예상도착시간: <%= request.getAttribute("time")%></h3>
	<h4>즐거운 식사 시간되세요~</h4>

</body>
</html>