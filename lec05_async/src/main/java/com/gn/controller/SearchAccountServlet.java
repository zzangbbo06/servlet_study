package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Account;

/**
 * Servlet implementation class SearchAccountServlet
 */
@WebServlet("/searchAccount")
public class SearchAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. Servlet에 Account List 목록에서
		// 해당 이름 존재하는지 확인
		// 이름이 포함된 사람 목록 응답
		List<Account> list = new ArrayList<Account>();
		list.add(new Account(1, "김철수"));
		list.add(new Account(2, "이영희"));
		list.add(new Account(3, "홍길동"));
		list.add(new Account(4, "김가남"));
		
		String name = request.getParameter("name");
//		JSONObject obj = new JSONObject();
		
		JSONArray arr = new JSONArray();
		
		for(Account a : list) {
			if(a.getName().contains(name)) {
				JSONObject obj = new JSONObject();
				obj.put("no", a.getNo());
				obj.put("name", a.getName());
				arr.add(obj);
				
			}
//			if(a.getName().equals(name)) {
//				obj.put("no", a.getNo());
//				obj.put("name", a.getName());
				
//			}
		}
		JSONObject result = new JSONObject();
		result.put("arr", arr);
		
		
		response.setContentType("application/json; charset=UTF-8");
//		array는 바로 넣기 불가능
		response.getWriter().print(result);
		
//		response.getWriter().print(obj); // PrintWriter와 같은 기능
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
