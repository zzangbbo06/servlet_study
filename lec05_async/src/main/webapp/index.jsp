<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 연습하기</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>1. 텍스트 데이터</h1>
	<h2>(1) Get 방식</h2>
	<input type = "text" name = "user_id" id = "user_id">
	<input type = "button" value = "아이디 길이 구하기" id="ajax_get_btn">
	<div id = "ajax_get_div"></div>
	<script>
		$(document).ready(function(){
			$("#ajax_get_btn").click(function(){
				console.log("1 : 클릭 이벤트 동작")
				const userId = $("#user_id").val();
				console.log("2 : 사용자 정보 받아와졌는가")
				$.ajax({
					url : "/getTextAjax?userId=" + userId,
					type : "get",
					success : function(data){
						
						// data => <p>아이디 : OOO (n글자)</p>
						console.log("3 : 정상 동작 여부")
						// $("#ajax_get_div").html(data);
						
						const h3 = $('<h3>').text(data);
						$("#ajax_get_div").html(h3);
						
					},
					error : function(){
						alert("요청 실패!!");
					}
				});
			});
		});
		
	</script>
	
	<h2>(2) Post 방식</h2>
	<button type = "button" id = "ajax_post_btn">
		아이디 길이 구하기 ver2.
	</button>
	<div id="ajax_post_div"></div>
	<script>
		$(document).ready(function(){
			$("#ajax_post_btn").click(function(){
				const userId = $("#user_id").val();
				$.ajax({
					url: "/postTextAjax",
					type: "post",
					data: {userId : userId},
					success : function(data){
						const p = $("<p>").text(data);
						$("#ajax_post_div").html(p);
					},
					error : function(){
						alert("요청 실패!");
					}
					
				});
			});
		});
	</script>
	
	
	<h1>성적 계산기</h1>
	<label for="kor">국어 : </label>
	<input type="number" id="kor" name = "kor"><br>

	<label for="eng">영어 : </label>
	<input type="number" id="eng" name = "eng"><br>
	
	<label for="math">수학 : </label>
	<input type="number" id="math" name = "math"><br>
	
	<button id="btnPost">계산</button>
	
	<div id="resultArea"></div>
	
	<script>
	 	$(document).ready(function(){
	 		$("#btnPost").click(function(){
	 		const sum = Number($("#kor").val()) + Number($("#eng").val()) + Number($("#math").val()); 
	 		// 숫자로 바꿔주야함
	 		const avg = sum / 3;
	 		let pass = null;
	 		if(Number($("#kor").val()) >= 40 && Number($("#eng").val()) >= 40 && Number($("#math").val())>= 40 && avg >= 60){
	 			pass = "합격";
	 		}else{
	 			pass = "불합격";
	 		}
	 		$.ajax({
	 			url : "/sumAvgPass",
	 			type : "post",
	 			data : {sum : sum,
	 					avg : avg,
	 					pass : pass},
	 			success : function(data){
	 				const p = $("<p>").text(data);
	 				$("#resultArea").html(p);
	 			},
	 			error : function(){
	 				alert("요청 실패!");
	 			}
	 			
	 			});
	 		});
	 	});
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>