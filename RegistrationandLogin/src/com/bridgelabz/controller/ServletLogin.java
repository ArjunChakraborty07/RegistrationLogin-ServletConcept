package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.databaseoperations.DatabaseOperations;
import com.bridgelabz.model.Model;


@WebServlet("/JSP/page1b")
public class ServletLogin extends  HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5512530923957167705L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		DatabaseOperations object=new DatabaseOperations();
		PrintWriter out=res.getWriter();		
		String email=req.getParameter("email");
		String pwd=req.getParameter("password");
		Model obj = new Model();		
		obj.setPwd(pwd);
		obj.setEmail(email);	
		try {
			ResultSet rs=object.dispalyData(obj);
			if(rs!=null)
			{							
				HttpSession session=req.getSession();
				session.setAttribute("data", rs);
				session.setAttribute("check", email);
				
				
				Cookie cookie= new Cookie("email",email);
				res.addCookie(cookie);
				
				out.println("<html><head></head><body onload=\"alert('Login Successfuld')\"></body></html>");
				res.sendRedirect("AccountPage.jsp");			
			}		
			else
				out.println("<html><head></head><body onload=\"alert('Login Denied')\"></body></html>");
				RequestDispatcher rd=req.getRequestDispatcher("RegistrationPage.jsp");				
				rd.include(req, res);	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
