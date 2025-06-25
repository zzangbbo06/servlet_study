<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> 당신은 이 페이지를
		<strong>
		<%
			Cookie[] cookies = request.getCookies();
			int count = 0;
			
			if(cookies != null){
				for(Cookie c : cookies){
					if(c.getName().equals("visit_count")){
						count = Integer.parseInt(c.getValue());
						break;
					}
				}
			}
		%>
		
		
		 <%= count %></strong>번 방문했습니다.
	</p>
</body>
</html>