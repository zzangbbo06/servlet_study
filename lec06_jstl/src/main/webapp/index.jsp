<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
    <!-- c로 시작하는 애들은 다 여기서 나온것들이다~  -->
    <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
    <%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL과 JSTL</title>
</head>
<body>
	<h1>1. EL의 내장객체</h1>
	<%
		pageContext.setAttribute("test", "페이지");
		request.setAttribute("test", "리퀘스트");
		session.setAttribute("test", "세션");
		application.setAttribute("test","애플리케이션");
	%>
	<h2>(1) JSP 방식 => 특정 범주 내장객체 지정</h2>
	<p><%= pageContext.getAttribute("test") %></p>
	
	<h2>(2) EL 방식</h2>
	<!-- 1. ~Scope로 끝나는 내장객체 사용
		2. 내장객체 지정없이 key만 사용: 가장 작은 범주부터 탐색 -->
	<p>${pageScope.test } </p>
	<p>${test }</p>
	
	<h1>2. EL로 객체 다루기</h1>
	<%@ page import = "com.gn.dto.Person" %>
	<%
		Person p = new Person("김철수", 77);
		request.setAttribute("person", p);
	%>
	<h2>(1) JSP 방식</h2>
	<%
		Person p1 = (Person)request.getAttribute("person");
	// request.getAttribute -> Object로 반환 되기 때문에
	%>
	
	<p>이름 : <%= p1.getName() %></p>
	<p>나이 : <%= p1.getAge() %></p>
	
	<h2>(2) EL 방식</h2>
	<!--  EL 방식으로 객체 정보를 꺼내는 경우: key값.필드명
			private 필드 직접 꺼내는거 아님!! getter 반드시 필요함
	 -->
	<p>이름 : ${person.name }</p>
	<p>나이 : ${person.age }</p>
	
	
	<h1>행성정보 출력하기</h1>
	<%@page import="com.gn.dto.Planet"%>
	<% 
		Planet planet = new Planet("지구", 1.5, true);
		request.setAttribute("planet", planet);
		// 정보를 저장 -> EL은 저장이 불가능
	%>
	<p>이름 : ${planet.name }</p>
	<p>태양으로부터의 거리 :  ${planet.distance }억 km</p>
	<p>거주 가능 여부 : ${planet.liveOrNot }</p>
	
	
	<h1>4. EL 연산자</h1>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>	
	<%
		request.setAttribute("num1", 7);
		request.setAttribute("num2", 2);
		request.setAttribute("str1", "햄버거");
		request.setAttribute("str2", "피자");
		
		List<String> menu = new ArrayList<String>();
		menu.add("짜장면");
		menu.add("짬뽕");
		request.setAttribute("menuList", menu);
	%>
	<p>
		산술 연산
		${num1 + num2 }
		${num1 - num2 }
		${num1 * num2 }
		${num1 div num2 }
		${num1 / num2 }
		${num1 mod num2 }	
	</p>
	<p>
		문자열 연결
		${str1 }${str2 }
		${str1 eq str2 }
		${str1 ne str2 }
	</p>
	<p>
		리스트 데이터 확인
		${empty menuList ?"메뉴가 비어있어요":"메뉴가 있어요" }
		${not empty menuList }
		
	</p>
	<p>
		대소 비교 & 논리 연산
		${num1 gt num2 }
		${num1 lt num2 }
		num1이 num2보다 크고, menuList가 비어 있지 않은 경우
		${num1 gt num2 and not empty menuList }
		
		
	</p>	
	
	<%
	    request.setAttribute("kor", 85);
	    request.setAttribute("eng", 90);
	    request.setAttribute("math", 78);
	    request.setAttribute("name1", "이순신");
	    request.setAttribute("name2", "김유신");
	
	    List<String> heroList = new ArrayList<>();
	    heroList.add("홍길동");
	    request.setAttribute("heroList", heroList);
	%>
	<%-- 1. 산술 연산
		(1) 국어, 영어, 수학 점수 평균 => 나누기
		(2) 평균 점수가 80점 초과 => "합격" 그렇지 않으면 "불합격"
		
		2. 문자열 연결
		(1) 이순신김유신 처럼 이름 연결
		(2) 두분의 이름이 동일한지 비교 => "동일 인물" 그렇지 않으면 "다르다"
		
		3. 리스트 비어있는가
		(1) heroList가 비어있는지 판단 -> "O" 그렇지 않으면 "X"
		(2) 국어 점수가 영어 점수보다 높거나 heroList가 비어 있지 않은 경우 true 출력
		(3) 수학 점수가 80점 미만 이고, 영어 점수가 90점 이상이면 true 출력 --%>
		
		<h2>1. 산술 연산</h2>
		<p>합계 : ${kor + eng + math}</p>
		<p>평균 : ${(kor + eng + math) / 3}</p>
		<p>합격여부 : 
		
		${((kor + eng + math) / 3) gt 80 ? "합격" : "불합격"}
				
		
		<h2>2. 문자열 연결</h2>
		${name1 }${name2 }
		${name1 eq name2 ? "동일인물":"다르다" }
		
		<h2>3. 리스트 비어있는가</h2>
		${empty heroList ? "O" : "X" }
		${kor gt eng or not empty heroList ? "true" : "false" }
		${math lt 80 and eng ge 90 ? "true" : "false" }
		
		
		
		
		<h1>5. JSTL Core Library</h1>
		<h2>(1) 변수 선언</h2>
		
		 
		<%-- <c:set></c:set> 이런식으로도 사용 가능 
		<c:set /> 
		
		 c:set 사용
			1. 자료형 선언하지 않음
			2. 초기값 반드시 작성
			3. c:set으로 지정한 값 스크립틀릿에서 꺼내 쓸 수 없음
			스크립틀릿에서 setting한 값은 jstl에서 꺼내쓸 수 있음 --%>
			
			 
		<c:set var="num3" value="10" scope="page"/>
		<!-- scope default 값이 page 안적어줘도 됨 -->
		<c:set var="num4" value="20"/>
		<c:set var="plus" value="${num3 + num4 }"/>
		<h2>(2)변수 출력</h2>
		<c:set var = "result" value = "<b>안녕하세요</b>" />
		<c:out value="${result }"/>
		<c:out value="${result }" escapeXml="false"/>
				
		<h2>(3) 조건문 : if</h2>
		<c:if test="${num3 le num4 }">
			<p>num3가 num4보다 작거나 같네요~</p>
		</c:if>
		
		<h2>(4) 조건문 : choose</h2>
		<!-- 1번째 when은 if, 두번째는 else if c:otherwise는 else -->
		<c:choose>
			<c:when test="${num3 gt 20 }">
				<p>num3이 20보다 큽니까?</p>
			</c:when>
			
			<c:when test="${num3 ge 10 }">
				<p>num3이 20보다 작거나 같으면서, 10보다 크거나 같습니까?</p>
			</c:when>
			<c:otherwise>
				<p>
					1. num3이 20보다 작거나 같다
					2. num3이 10보다 작다
				</p>
			</c:otherwise>
		</c:choose>
		
			
		
		
		<h1>6. 사이트 테마 설정</h1>
		<form method="post" action="/setTheme">
		    <button type="submit" name="theme" value="dark">다크모드</button>
		    <button type="submit" name="theme" value="light">라이트모드</button>
		</form>
	
	
	<h2>(5) 반복문 : forEach</h2>
    <!-- 기본 for문 처럼 사용하기 -->
    <c:forEach var="i" begin="1" end="10" step="2">
    	<p>반복 숫자 : ${i }</p>
    </c:forEach>
	
	<!-- 향상된 for문 처럼 사용하기 -->
	<%
		String[] colors = {"red", "green", "blue"};
		request.setAttribute("colors", colors);
	%>
	
	<ul>
		<c:forEach var="color" items="${colors }">
			<li style="color:${color }">${color }</li>
		</c:forEach>	
	</ul>
	
	<!-- varStatus 속성 -->
	<c:forEach var="num" begin="0" end="5" varStatus="vs">
		<p>
			숫자: ${num }, 인덱스 : ${vs.index }, 카운트: ${vs.count },
			첫번째? : ${vs.first }, 마지막? : ${vs.last }
		</p>
		
	</c:forEach>
	<!-- <%=request.getContextPath() %> -> 최상위 경로를 반환 -->
	<script src="<%=request.getContextPath() %>/resources/jquery-3.7.1.js">
	</script>
	<a href="<%= request.getContextPath() %>/boardList">게시판</a>
	
	
	
	
	<script src="<c:url value='/resources/jquery-3.7.1.js'/>"></script>
	<a href="<c:url value = '/boardList'/>">게시판</a>
	<!-- 파라미터 사용하기 -->
	<c:url var="testUrl" value="/boardList">
		<c:param name="nowPage" value="1"/>
	</c:url>
	<a href="${testUrl }">게시판</a>
	
	
	<h1>8. JSTL Formatting Library</h1>
	<h2>(1) 숫자 정보 포맷팅</h2>
	<fmt:formatNumber value="1234.567" type="number"/><br>
	<fmt:formatNumber value="0.875" type="percent"/><br>
	
	<fmt:formatNumber value="1234.567" pattern="#,###.##"/><br>
	<fmt:formatNumber value="1234.5" pattern="00000.00"/><br>
	
	<h2>(2) 날짜 정보 포맷팅</h2>
	<c:set var="now" value="<%= new java.util.Date() %>"/>
	<fmt:formatDate value="${now }" type="date" /><br>
	<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /><br>
	
	<h1>9. JSTL Function Library</h1>
	<c:set var="data" value="How Are You? I am fine"/>
	<!-- 동적인 데이터라고 가정할때 아래처럼 써야함 -->
	<p><c:out value = "${data }"/></p>
	<p><c:out value="${fn:toUpperCase(data) }"/></p>
	<p><c:out value="${fn:replace(data,'fine', 'apple') }"/></p>
	
	
	<h1>10. 별찍기</h1>
	<c:forEach var = "i" begin = "1" end = "5">
			<c:forEach var = "j" begin ="1" end = "${i }">
				*
			</c:forEach>
			<br>
	</c:forEach>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>