package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class BookReserveEndServlet
 */
@WebServlet("/bookReserveEnd")
public class BookReserveEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReserveEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/book/confirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/book/confirm.jsp");
		String name = request.getParameter("user_name");
		String phone = request.getParameter("user_phone");
		String email = request.getParameter("user_email");
		String bookName = request.getParameter("book_name");
		String borrowPeriod = request.getParameter("borrow_period");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "자바 프로그래밍 입문");
		map.put("2", "웹 개발의 기초");
		map.put("3", "데이터베이스 시스템");
		
			
		String temp = map.get(bookName);
		
		int price = 0;
		switch(bookName) {
		case "1":
			price = 1500;
			break;
		case "2":
			price = 1800;
			break;
		case "3":
			price = 2000;
		}
		int resultPrice = price + 500 * (Integer.parseInt(borrowPeriod) - 1); 
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("bookName", temp);
		request.setAttribute("borrowPeriod", borrowPeriod);
		request.setAttribute("resultPrice", resultPrice);
	
		
		
		dispatcher.forward(request, response);
		
		
	}

}
