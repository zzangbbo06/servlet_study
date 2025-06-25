package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class TitlePrefixWrapper extends HttpServletRequestWrapper{

	public TitlePrefixWrapper(HttpServletRequest request) {
		super(request);
	}
	
	public String getParameter(String name) {
		String value = super.getParameter(name);
		
			if(name.equals("title") && value != null) {
				// key값이 title이 들어오면
				return "[공지]" + value;
			}
			return value;
	}
	
}
