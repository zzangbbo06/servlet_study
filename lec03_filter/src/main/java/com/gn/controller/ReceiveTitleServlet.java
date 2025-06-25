package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ReceiveTitleServlet
 */
@WebServlet("/board/write")
public class ReceiveTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveTitleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===== 요청 확인 =====");
		String title = request.getParameter("title");
		System.out.println(title);
		
		// 화면단 경로는 반드시 /로 시작
		// /없이 화면 설정 -> /receive/views/msgShow.jsp
		RequestDispatcher view 
//								= request.getRequestDispatcher("/views/msgShow.jsp");
								= getServletContext().getRequestDispatcher("/board/write/title.jsp");
		request.setAttribute("title", title);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// Get으로 들어온것과 Post로 들어온 방법이 같을때 사용 가능
	}

}
