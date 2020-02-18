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
 * Servlet Filter implementation class EditCityFilter
 */
@WebFilter("/JSP/editc")
public class EditCityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EditCityFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	static boolean charCheck(char input_char) 
    { 
        // CHECKING FOR ALPHABET 
        if ((input_char >= 65 && input_char <= 90) 
            || (input_char >= 97 && input_char <= 122)) 
            return true; 
  
        // CHECKING FOR DIGITS 
        else if (input_char >= 48 && input_char <= 57) 
            return false; 
  
        // OTHERWISE SPECIAL CHARACTER 
        else
            return false; 
    } 
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		String city=request.getParameter("city");	
		int ctr=city.length();
		String str[]=city.split(" ");
		for(int i=0;i<str.length;i++)
		{
			char[] ch=str[i].toCharArray();
			for (int j = 0; j < ch.length; j++) {
				if(!charCheck(ch[j]))
				{
					ctr--;
				}
			}
		}
		if(!city.trim().isEmpty()&&ctr==city.length())
		{
			chain.doFilter(request, response);
		}
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
		// TODO Auto-generated method stub
	}

}
