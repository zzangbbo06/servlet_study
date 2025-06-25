package com.gn.common.filter;

import java.io.IOException;

import com.gn.common.wrapper.TitlePrefixWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/board/write")
//⛳ 이 필터는 "/board/write" 경로로 들어오는 요청이 있을 때 동작한다.
//→ 즉, 이 URL을 처리하는 서블릿이 실행되기 전에 필터가 먼저 가로챈다.



//클라이언트 요청: POST /board/write
//↓
//[📛 Filter 동작 (@WebFilter("/board/write"))]
//↓
//[🛠 래퍼로 감싸거나 전처리 수행]
//↓
//[🚪 chain.doFilter() → 서블릿으로 전달]
//↓
//[🧠 @WebServlet("/board/write")에 해당하는 서블릿 실행]


public class TitlePrefixFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		TitlePrefixWrapper wrappedRequest = new TitlePrefixWrapper((HttpServletRequest)arg0);
		arg2.doFilter(wrappedRequest, arg1);
		
	}

}
