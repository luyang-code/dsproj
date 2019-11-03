package com.maple.MapleMall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		final String uri = req.getRequestURI().startsWith("/") ? req.getRequestURI().substring(1) : req.getRequestURI();
//		System.out.println(uri);
		//放行登录请求和静态资源
		if(uri.contains("/login") || uri.contains("/assets")){
			chain.doFilter(req, resp);
		}

		if(req.getSession().getAttribute("adminname") == null) {
			resp.setHeader("Content-type", "text/html;charset=UTF-8");
			resp.getWriter().print("<script language=\"javascript\">alert('您还没有登录或长时间未操作，请重新登录！');window.location.href='../login.html'</script>");

		}else {
			chain.doFilter(req, resp);
		}
	}

}
