<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value='/resources/jquery-3.7.1.js'/>"></script>
</head>
<body>
	<h1>회원가입</h1>
	<%@ include file="/views/include/nav.jsp" %>
	<form id="createMemberFrm">
		<input type="text" id="member_id" placeholder="아이디"> <br>
		<input type="password" id="member_pw" placeholder="비밀번호"> <br>
		<input type="password" id="member_pw_check" placeholder="비밀번호 확인"> <br>
		<input type="submit" value="회원가입"> 
	</form>
	<script>
		$("#createMemberFrm").submit(function(e){
			e.preventDefault();
			// 기본 이벤트를 일단 막고싶을때
			
			// 1. 사용자 입력값 가져오기
			const memberId = $('#member_id').val();
			const memberPw = $('#member_pw').val();
			const memberPwCheck = $('#member_pw_check').val();
			// 2. 유효성 검사(비어있는값이 아닐것, 정규식을 통과할 것 등)
			const idReg = /^[a-zA-Z0-9]{4,12}$/;
			const pwReg = /^[a-zA-Z0-9!@#$%^&*]{4,20}$/;
			// ^안녕하세요 $안녕히가세요
			// 소문자 대문자 숫자를 섞어쓸수 있고 4-12자리까지 사용가능
			//  // 표시는 정규식 들어갈거야 라는 말
			if(!memberId){
				alert("아이디를 입력하세요.");
			}else if(!idReg.test(memberId)){
				alert("아이디는 영문 또는 숫자로 4~12자리만 가능합니다");
				
			}else if(!memberPw){
				alert("비밀번호를 입력하세요");
			}else if(!pwReg.test(memberPw)){
				alert("비밀번호는 영문/숫자/특수문자 포함 4~20자리만 가능합니다.");
			}else if(memberPw != memberPwCheck){
				alert("비밀번호가 일치하지 않습니다.");
			}else{
				// 3. ajax로 회원가입 요청
				$.ajax({
					url:"/memberCreate",
					type:"post",
					data : {
						memberId : memberId,
						memberPw : memberPw
					},
					dataType:'json',
					success : function(data){
						
					}
				
				});
			}
			
			// 3. ajax로 회원가입 요청
			
			
			
		})
	</script>
</body>
</html>