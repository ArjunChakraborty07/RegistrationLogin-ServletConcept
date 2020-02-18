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
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/JSP/page1b")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        
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
		
		HttpServletRequest req=(HttpServletRequest) request;
		String email=req.getParameter("email");
		String pwd=req.getParameter("password");
//		Cookie cookie[]=req.getCookies();
//		String check=cookie[0].getValue();
//		if(check.equals("true"))
//		{
			
//		}
//		cookie=null;
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		boolean check = m.find();
		char psd[]=pwd.toCharArray();
		
		if(check==true && psd.length>4)
			chain.doFilter(request, response);		
		else
		{
			PrintWriter out=response.getWriter();
			out.println("<html><head></head><body onload=\"alert('Login Denied')\"></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
			rd.include(request, response);
		}		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
