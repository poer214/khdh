package com.dh.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req,
			ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("before");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().println("<a href=\"main.html\">메인으로 돌아가기</a><br>");
		chain.doFilter(req, resp);
		System.out.println("after");
	}
}
