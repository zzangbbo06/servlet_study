package com.gn.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AnonymousWrapper extends HttpServletRequestWrapper{

	public AnonymousWrapper(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(name.equals("writer") || value.equals("null") || value.equals("Null") || value.isEmpty()) {
			return value = "익명";
		}else {
			return value;
		}
	}

}
