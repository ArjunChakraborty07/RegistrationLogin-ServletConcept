package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.databaseoperations.DatabaseOperations;
import com.bridgelabz.model.Model;


@WebServlet("/JSP/editfn")
public class EditServletName extends HttpServlet { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Model obj=null;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DatabaseOperations object=new DatabaseOperations();		
		String pwd=null;;
		pwd=req.getParameter("name");				
		req.setAttribute("name",pwd);
		
		try {
			PrintWriter out=res.getWriter();
			out.println("<script type='text/javascript'> alert('Name Changed') Location='EditData.jsp'	</script>");
			object.editDataName(req, res);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
