package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.databaseoperations.DatabaseOperations;
import com.bridgelabz.model.Model;


@WebServlet("/JSP/editpd")
public class EditServletPassword extends HttpServlet { 

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Model obj=null;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DatabaseOperations object=new DatabaseOperations();		
		String pwd=null;;
		pwd=req.getParameter("password");				
		req.setAttribute("password",pwd);
		
		PrintWriter out=res.getWriter();
		out.println("<script type='text/javascript'> alert('Password Changed') Location='EditData.jsp'	</script>");
		object.editDataPassword(req, res);
	}
}
