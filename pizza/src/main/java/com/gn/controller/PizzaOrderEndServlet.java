package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class PizzaOrderEndServlet
 */
@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaOrderEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/pizza/result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/pizza/result.jsp");
		String name = request.getParameter("user_name");
		String phone = request.getParameter("user_phone");
		String email = request.getParameter("user_email");
		String size = request.getParameter("pizza_size");
		
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("1", "small");
		map.put("2", "medium");
		map.put("3", "large");
		
		Map<String,Integer> sizeMap = new HashMap<String, Integer>();
		sizeMap.put("1", 15900);
		sizeMap.put("2", 21000);
		sizeMap.put("3", 27900);
		
		
		String mapSize = map.getOrDefault(size, "선택 안됨"); // Null 처리
		int sizePrice = sizeMap.getOrDefault(size, 0); // Null 처리
		
		String [] topping = request.getParameterValues("pizza_topping");
		int topp_price = 0;
		List<String> toppingName = new ArrayList<String>();
		
		if (topping != null) { // Null 처리
			for(String t : topping)
			switch (t) {
	        	case "1":
	        		toppingName.add("새우");
	        		topp_price += 2000; // 누적해서 더하기
	        		break;
	        	case "2":
	        		toppingName.add("고구마");
	        		topp_price += 1000; // 누적해서 더하기
	        		break;
	        	case "3":
	        		toppingName.add("감자");
	        		topp_price += 1000; // 누적해서 더하기
	        		break;
	        	case "4":
	        		toppingName.add("파인애플"); 
	        		topp_price += 1000; // 누적해서 더하기
	        		break;
				}
		} else {
		    // topping이 null이면 기본값 처리
		    topp_price = 0;
		}
		int resultPrice = sizePrice + topp_price;
		
		String time = request.getParameter("delivery_time");
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("size", mapSize);
		request.setAttribute("topping", toppingName);
		request.setAttribute("price", resultPrice);
		request.setAttribute("time", time);
		
		dispatcher.forward(request, response);
	}

}
