<%@page import="com.gn.dtp.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<h1>Cookie</h1>
	<ul>
		<li>
			<a href = "/makeCookie">쿠키 생성</a>
		</li>
		<li>
			<a href = "/editCookie">쿠키 수정</a>
		</li>
		<li>
			<a href = "/deleteCookie">쿠키 삭제</a>
		</li>
	</ul>
	<h2>현재 쿠키 값 확인</h2>
	<%
		// 1. 클라이언트가 보낸 쿠키 배열 가져오기
		Cookie[] cookies = request.getCookies();
		String userId = "쿠키 없음";
		
	
		// 2. 쿠키 배열에서 원하는 쿠키 찾기
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("user_id")){
					userId = c.getValue();
					break;
				}
			}
		}
	%>
	<p>user_id 쿠키값 : <%= userId %></p>
	<h1>Session</h1>
	<ol>
		<li>
			<a href="/createSession">세션 생성</a>
		</li>
		<li>
			<a href="/updateSession">세션 수정</a>
		</li>
		<li>
			<a href="/removeSession">세션 삭제</a>
		</li>
	</ol>
	
	<%
		String memberId = "세션 없음";
	// session은 JSP에서는 내장객체이므로 써줄 필요 없지만 다른데서는 false로 해서 가지고와야함
		if(session != null){
			if(session.getAttribute("member_id") != null){
				// member_id라는 키를 가지고 있는 session이 있다면
				memberId = (String)session.getAttribute("member_id");
			}
		}
	
	%>
	<p>세션 정보 : <%= memberId %></p>
	
	
	<%

		Account memberLogin = null;
	// session은 JSP에서는 내장객체이므로 써줄 필요 없지만 다른데서는 false로 해서 가지고와야함
		if(session != null){
			if(session.getAttribute("account") != null){
				// member_id라는 키를 가지고 있는 session이 있다면
				memberLogin = (Account)session.getAttribute("account");
			}
		}
	%>
	
	<% if (memberLogin != null) { %>
	<p>관리자님 환영합니다!</p>
	<a>로그아웃</a>
	<% } else{%>
	<h1>로그인 구현</h1>
	<form action="/login" method="post">
		<label>아이디 : </label>
		<input type="text" name = "user_id"><br>
		<label>비밀번호 : </label>
		<input type="password" name = "user_pw">
		<input type="submit" value="로그인">
	</form>
	<% } %>
	
	
	
	
	<h1>상품 목록 페이지</h1>
	<a href = "/productList">상품목록</a>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	

	
	
</body>
</html>