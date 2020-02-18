package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class RegistrationFilter
 */
@WebFilter("/JSP/page1a")
public class RegistrationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RegistrationFilter() {
        
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
		
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("password");
		String email=request.getParameter("email");
		
		char name[]=uname.toCharArray();
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		boolean check = m.find();
		
		char psd[]=pwd.toCharArray();
		
		if(psd.length>5 && name.length>5 && check==true)
		chain.doFilter(request, response);
		else
		{
			PrintWriter out=response.getWriter();
			out.println("<html><head></head><body onload=\"alert('Invalid Inputs')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("RegistrationPage.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
