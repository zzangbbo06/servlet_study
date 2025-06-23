package com.gn.mapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// 간단하게 서블릿 매핑
// form -> action과 같게 해야함
@WebServlet("/submitId") 

public class InputIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InputIdServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get 방식 요청");
		String userId= request.getParameter("user_ID");
		System.out.println("너의 아이디는: " + userId);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
