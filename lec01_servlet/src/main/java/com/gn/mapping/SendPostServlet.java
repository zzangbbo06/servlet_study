package com.gn.mapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/loginMember")
public class SendPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SendPostServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// Post 방식은 인코딩 필수 ! -> 한글 인코딩 + getParameter를 쓰기전에 반드시 써야함
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("로그인 성공");
		
		
		response.setContentType("text/html charset=UTF-8");
		PrintWriter out = response.getWriter();
		
//		out.println("<html>");
//		out.println("<head> ");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
//		out.println("<title>회원가입 결과화면</title>");
//		out.println("</head>");
//		
//		out.println("<body>");
//		out.println("<h1>반가워요 "+id+"님</h1>");
//		out.println("<h2>비밀번호가 " + pw + "이시네요~</h2>");
//		out.println("<a href='/'>홈페이지로 이동</a>");
//		out.println("</body>");
//		out.println("</html>");
//		
//		out.flush();
		RequestDispatcher view = request.getRequestDispatcher("views/joinSuccessPost.jsp");
		
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		view.forward(request, response);
	}

}
