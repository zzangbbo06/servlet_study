package com.gn.filter;

import java.io.IOException;

import com.gn.wrapper.AnonymousWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/comment/write")
public class AnonymousFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		AnonymousWrapper wrappedRequest = new AnonymousWrapper((HttpServletRequest)arg0);
		arg2.doFilter(wrappedRequest, arg1);
	}

}
