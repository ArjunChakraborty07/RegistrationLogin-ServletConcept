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
 * Servlet Filter implementation class EditPhoneFilter
 */
@WebFilter("/JSP/editpn")
public class EditPhoneFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EditPhoneFilter() {
        
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
		
		String phone=request.getParameter("phone");	
		char ph[]=phone.toCharArray();
		Pattern p = Pattern.compile("[^0-9]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(phone);
		boolean check = m.find();
		if(ph.length!=10||check==true)
		{
			PrintWriter out=response.getWriter();
			out.println("<html><head></head><body onload=\"alert('Edit Denied')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("EditData.jsp");
			rd.include(request, response);
		}
		else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
