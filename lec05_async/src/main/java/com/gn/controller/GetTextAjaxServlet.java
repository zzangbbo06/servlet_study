package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GetTextAjaxServlet
 */
@WebServlet("/getTextAjax")
public class GetTextAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTextAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		// 1. HTML 형태로 응답(default)
		// (1) 어떤 형식으로 정보를 보내줄 것인가
//		response.setContentType("text/html; charset=utf-8");
//		// (2) 연결 통로 생성
//		PrintWriter out = response.getWriter();
//		// (3) 통로로 정보 내보내기
//		int leng = userId.length();
//		out.println("<p>아이디 : "+ userId +"("+ leng+"글자)</p>");
	
		// 2. (순수) 문자 형태로 응답
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		int leng = userId.length();
		out.println("순수 문자 아이디 : " + userId + "(" + leng +")" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
