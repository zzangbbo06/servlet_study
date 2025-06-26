package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import com.gn.dtp.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1001, "키보드", 25000));
		list.add(new Product(1002, "마우스", 15000));
		list.add(new Product(1003, "모니터", 180000));
		
		String selectedItem = request.getParameter("shopping_list");
		String selectedItemName = null;

		switch(selectedItem) {
		case "1":
			selectedItemName = "키보드";
			break;
		case "2":
			selectedItemName = "마우스";
			break;
		case "3":
			selectedItemName = "모니터";
			break;
		}
		
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getName().equals(selectedItemName)) {
				Product selectedProduct = list.get(i);
				HttpSession session = request.getSession(true);
				
				List<Product> cart = (List<Product>)session.getAttribute("cart");
				if (cart == null) {
					cart = new ArrayList<>();
				}

				// 상품 추가
				cart.add(selectedProduct);
				session.setAttribute("cart", cart);
				session.setMaxInactiveInterval(60 * 30);
				response.sendRedirect("/views/productList.jsp");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
