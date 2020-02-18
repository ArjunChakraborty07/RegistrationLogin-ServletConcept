package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EditPasswordFilter
 */
@WebFilter("/JSP/editpd")
public class EditPasswordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EditPasswordFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String pwd=request.getParameter("password");
		System.out.println(pwd);
		char psd[]=pwd.toCharArray();
		
		if(psd.length>=5&&!pwd.trim().isEmpty())
		chain.doFilter(request, response);
		else
		{
			PrintWriter out=response.getWriter();
			out.println("<html><head></head><body onload=\"alert('Edit Denied')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("EditData.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
