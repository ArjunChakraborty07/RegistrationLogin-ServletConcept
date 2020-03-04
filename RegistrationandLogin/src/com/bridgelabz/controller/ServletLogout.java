package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.databaseoperations.DatabaseOperations;



@WebServlet("/JSP/page2")
public class ServletLogout extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		DatabaseOperations object=new DatabaseOperations();
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    res.setHeader("expires","0"); //Proxies
		String button=req.getParameter("button");
		if(button.equals("logout"))
		{
			PrintWriter out=res.getWriter();
			out.println("<script type='text/javascript'>confirm('Are you sure want to delete your account') Location='RegistrationPage.jsp'	</script>");
//			PrintWriter out= res.getWriter();
//			out.println("<html><head></head><body onload=\"alert('Logout Successful')\"></body></html>");
			RequestDispatcher rd=req.getRequestDispatcher("RegistrationPage.jsp");				
			rd.include(req, res);
		}
		if(button.equals("edit"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("EditData.jsp");				
			rd.include(req, res);
		}
		if(button.equals("delete"))
		{
			object.deleteData(req, res);
		}
		if(button.equals("admin"))
		{
			HttpSession session=req.getSession();
			ResultSet rs;
			rs = object.dispalyAdmin();
			session.setAttribute("admin", rs);
			RequestDispatcher rd=req.getRequestDispatcher("AdminPage.jsp");				
			rd.include(req, res);						
		}
	}
}
