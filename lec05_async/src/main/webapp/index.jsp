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
	
	<h1>JSON + AJAX</h1>
	<input type = "text" id = "searchName">
	<button type = "button" id = "json_get_btn"></button>
	<div id = "json_get_div"></div>
	<script>
		$(document).ready(function(){
			$("#json_get_btn").click(function(){
				// 1. 사용자 이름 정보 가져오기
				const keyword = $("#searchName").val();
				// 2. get 방식(비동기) 요청
				$.ajax({
					url : "/searchAccount?name=" + keyword,
					type: "get",
					dataType : "json",
					success : function(data){
					// 4. 화면에 목록 형태로 출력
						// const no = data.no;
						// const name = data.name;
						
					//	$('#json_get_div').append('<p>' + no + "번 : " + name + "</p>");
					if(data.arr.length != 0){
						for(let i = 0; i < data.arr.length; i++){
							const account = data.arr[i];
							$("#json_get_div").append('<p>' + account.no + "번 : " + account.name + "</p>");
						}
					}
					
					}
				});
				
				
			});
		});
	</script>
	
	<h1>도서 검색</h1>
	<label>도서명: </label>
	<input type="text" id="searchBook">
	<button id="book_get_btn">조회</button>
	<div id="book_get_div"></div>
	
	<script>
		$(document).ready(function(){
			$("#book_get_btn").click(function(){
				const bookName = $("#searchBook").val();
				$.ajax({
					url : "/searchBook?bookName=" + bookName,
						// ?파라미터값=" + 찾고자 하는 값 -> 서버로 전송 = 서블릿
					type : "get",
					dataType : "json",
					// 서버에서 오는 응답의 형식
					success : function(result){
						// 서버의 응답
						// result = {
   						//   array: [ { no: 1, name: "홍길동" }, { no: 2, name: "김철수" } ]
						// array -> 내가 설정한 별명
    					// }
					if(bookName === ""){
						alert("원하는 책의 키워드를 입력해주세요.");
						return;
					}
					
					
					if(result.array.length != 0 ){
						for(let i = 0; i < result.array.length; i++){
							const book = result.array[i];
							$("#book_get_div").append('<p>' + book.no + '번 : ' + book.bookName + ' - 저자 : ' + book.name + '</p>');
						}
					}else{
						alert("검색 결과가 없습니다.");
					}	
					}
				});
			});
		});
	
	</script>
	<h1>카테고리별 상품 조회</h1>
	<select id = "categorySelect">
		<option value = "1">전자제품</option>
		<option value = "2">생활용품</option>
		<option value = "3">패션</option>
	</select>
	<button type = "button" id = "searchBtn">조회</button>
	<div id = "productListArea"></div>
	
	<script>
	 $(function(){
		$("#categorySelect").change(function(){
			// 1. 선택된 카테고리 정보 가져오기
			const categoryCode = $(this).val();
			console.log(categoryCode);
			// 2. ajax 통신을 통해 목록 조회
			$.ajax({
				url : "/searchProduct",
				type : "post",
				data : {code : categoryCode},
				// 파라미터값으로 가져올 이름, 위에 변수명
				dataType : 'json',
				success : function(data){
				// 3. 화면에 출력하기
				if(data.arr.length === 0){
					$("#productListArea").html("해당 카테고리의 상품이 없습니다.");
					
				}else{
					for(let i = 0; i< data.arr.length; i++){
						const product = data.arr[i];
						$("#productListArea").append("<p>" + product.name"은 " + product.price + "원 입니다.</p>");
					}
				}
					
				}
			});			
		}) ;
	 });
	
	</script>
	
	
	<h1>방명록 비동기 통신</h1>
	<a href = "/" id = "show_guestBook">방명록 확인</a>
	
	<div id = "guestBook" style = "display : none">
	<h1>방명록 검색</h1>
	<label>이름</label>
	<input type="text" id="guestBook_name">
	<br>
	<label>메세지</label>
	<br>
	<textarea rows="3" cols="20" id = "guestBook_msg"></textarea>
	<button id="guestBook_get_btn">작성</button>
	</div>
	<ul id ="result_guestBook"></ul>
	
	<script>
	$(document).ready(function(){
		$("#show_guestBook").click(function(e){
			e.preventDefault(); // 이동 막기
			
			$("#show_guestBook").hide();	
			
			$("#guestBook").show();
			
			$("#guestBook_get_btn").click(function(){
				const name = $("#guestBook_name").val();
				const msg = $("#guestBook_msg").val();
				// 조건문은 먼저 적어주는게 좋음.
				if (name === "" || msg === "") {
					alert("이름과 메세지를 모두 입력해주세요.");
					return;
				}
				$.ajax({
					url : "/guestBook_confirm",
					type : "post",
					data : {
						name : name,
						msg : msg		
					},
					dataType : 'json',
					success : function(result){
						$("#result_guestBook").append("<li> 이름: " + result.name + "</li>")
						$("#result_guestBook").append("<li> 메세지: " + result.msg + "</li>")
						$("#result_guestBook").append("<li> 시간: " + result.date + "</li>")
						
						// 초기화 방법
						$("#guestBook_name").val("");
						$("#guestBook_msg").val("");
					}, 
					error : function(){
							alert("서버 오류입니다. 잠시만 기다려주십시오.")
					}
				});
				
			});
			
		});
	});
	</script>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>