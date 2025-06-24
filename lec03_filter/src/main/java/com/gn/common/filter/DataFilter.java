package com.gn.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class DataFilter
 */
//@WebFilter(servletNames = "receiveDataServlet")
@WebFilter(urlPatterns = "/receive/data")
// Servlet 이전에 데이터를 필터링하는데 어노테이션 방법으로 Servlet에 요청이 들어온것을 알 수 있다
public class DataFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public DataFilter() {
        super();
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//필터가 소멸될 때 실행
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청과 응답 처리

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터가 초기화될때 실행 -> 서버가 실행 됐을때
	}

}
