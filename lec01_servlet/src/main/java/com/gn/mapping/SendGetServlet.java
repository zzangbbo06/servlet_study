package com.gn.mapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/joinMember")
public class SendGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SendGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user_name");
		String gender = request.getParameter("gender");
//		age라고 하더라도 String으로 데이터가 들어옴 -> int로 사용하고 싶을때 
		int age = Integer.parseInt(request.getParameter("user_age"));
		
//		checkbox는 배열로 넘어옴
		String [] hobby = request.getParameterValues("hobby");
		
		System.out.println("이름 : " + name);
		if(gender.equals("1")) {
			System.out.println("남자");
		}else if(gender.equals("2")) {
			System.out.println("여자");
		}
		
		System.out.println("나이: " + age);
		
		if(hobby == null || hobby.length == 0) {
			System.out.println("취미 없음");
		}else {
			System.out.println("===== 취미 목록 =====");
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("1", "야구");
			map.put("2", "농구");
			map.put("3", "축구");
			
			
			for(int i = 0; i < hobby.length; i++) {
				String temp = map.get(hobby[i]);
				System.out.println(temp);
			}
		}
		
		// 1. 응답형식 지정
		response.setContentType("text/html; charset=UTF-8");
		// 내가 응답할 형식은 html이고 문자 인코딩 방식이 UTF-8
		// 띄어쓰기까지 양식이기 때문에 절대 바꾸면 안됨
		
		// 2. 응답하고자 하는 사용자와의 연결통로 생성
		PrintWriter out = response.getWriter();
		
		// 3. HTML 구문 한줄씩 쌓기
//		out.println("<html>");
//		out.println("<head> ");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
//		out.println("<title>회원가입 결과화면</title>");
//		out.println("</head>");
//		
//		out.println("<body>");
//		out.println("<h1>"+name+"님, 환영합니다</h1>");
//		out.println("<h2>앞으로도 자주 와주실꺼죠?</h2>");
//		out.println("<a href='/'>홈페이지로 이동</a>");
//		out.println("</body>");
//		out.println("</html>");
		
		// 4. 쌓여있는 데이터 밀어내기
//		out.flush();
		
		// jsp로 변경
		// 1. JSP로 요청을 넘기는 역할 = 어느 JSP에 넘길지 지정
		RequestDispatcher view = request.getRequestDispatcher("views/joinSuccess.jsp");
		// 2. JSP에게 데이터를 넘겨주기 -> 왼쪽은 어떤 값이 들어가더라도 상관 X, but 관례
		request.setAttribute("name", name);
		// 3. 화면을 JSP에게 넘기고, 응답을 JSP에게 맡기기
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
