package mvcproject.web.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	String encoding;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
        chain.doFilter(request, response); // 필터 체인 계속 진행
	}

	public void destroy() {
		
	}
}
