package com.balajisiddi.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class UserCount
 */
@WebFilter(description = "This will filter the user who are visiting the site", urlPatterns = { "/UserCount" })
public class UserCount implements Filter {
	static int count=0; 
    /**
     * Default constructor. 
     */
    public UserCount() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		PrintWriter pw= response.getWriter();
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		pw.print("<br/>Total visitors "+(++count));  
        pw.close();  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
