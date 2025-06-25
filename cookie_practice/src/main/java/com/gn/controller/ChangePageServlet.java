package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ChangePageServlet
 */
@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		int count = 0;				
//		Cookie c = new Cookie("visit_count", String.valueOf(count++));
//		c.setMaxAge(60 * 60 * 24);
//		response.addCookie(c);
		int count = 0;

		// 1. 쿠키 배열에서 "visit_count" 쿠키 찾기
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    for (Cookie c : cookies) {
		        if ("visit_count".equals(c.getName())) {
		            count = Integer.parseInt(c.getValue());
		            break;
		        }
		    }
		}

		// 2. 방문 수 증가
		count++;

		// 3. 증가된 값으로 쿠키 생성 및 전송
		Cookie newCookie = new Cookie("visit_count", String.valueOf(count));
		newCookie.setMaxAge(60 * 60 * 24); // 하루 유지
		response.addCookie(newCookie);

		// 4. JSP에서 출력할 수 있도록 전달 (선택)
		request.setAttribute("count", count);
		request.getRequestDispatcher("/views/countPage.jsp").forward(request, response);

		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
