package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bridgelabz.databaseoperations.DatabaseOperations;
import com.bridgelabz.model.Model;


@WebServlet("/JSP/page1a")
public class ServletRegister extends  HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5512530923957167705L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		DatabaseOperations object=new DatabaseOperations();
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    res.setHeader("expires","0"); //Proxies
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("password");
		String email=req.getParameter("email");
		Model obj = new Model();
		obj.setEmail(email);
		obj.setPwd(pwd);
		obj.setUname(uname);
		try {
			boolean flag= object.updateData(obj);
			if(flag==true)
			{
				HttpSession session=req.getSession();
				session.setAttribute("username",uname);
				PrintWriter out=res.getWriter();
				out.println("<html><head></head><body onload=\"alert('Registration Successful')\"></body></html>");
				RequestDispatcher rd=req.getRequestDispatcher("RegistrationPage.jsp");
				rd.include(req, res);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
