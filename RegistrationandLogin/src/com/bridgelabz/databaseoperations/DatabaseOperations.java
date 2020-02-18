package com.bridgelabz.databaseoperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.model.Model;
import com.bridgelabz.service.Service;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DatabaseOperations implements Service{

	public void deleteData(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		ResultSet rs=null;
		HttpSession session= req.getSession();
		rs=(ResultSet) session.getAttribute("data");
		String email=rs.getString("email_id");
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Registration";
		Class.forName(driver);
		Connection conn=(Connection) DriverManager.getConnection(url,"Arjun","password");
		String query="delete from registration where email_id=?";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
		ps.setString(1, email);
		ps.execute();
		conn.close();
		req.removeAttribute("data");
		PrintWriter out=res.getWriter();
		out.println("<html><head></head><body onload=\"alert('Account Deleted')\"></body></html>");
		RequestDispatcher rd=req.getRequestDispatcher("RegistrationPage.jsp");
		rd.include(req, res);
	}
	
	public ResultSet dispalyData(Model obj) throws ClassNotFoundException, SQLException
	{
		String Driver="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn=(Connection) DriverManager.getConnection(URL,"Arjun","password");
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=st.executeQuery("select * from registration");
		
		while(rs.next())
		{
			if(obj.getPwd().equals(rs.getString("password"))&&obj.getEmail().equals(rs.getString("email_id")))
			{								
				return rs;
			}	
		}
		return null;
	}
	
	public void editDataPassword(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException {

		HttpSession session = req.getSession();
		ResultSet rs = (ResultSet) session.getAttribute("data");
		System.out.println("check");
		String email = rs.getString(3);
		String pwd = (String) req.getAttribute("password");
		// Setting data to process

		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn = (Connection) DriverManager.getConnection(URL, "Arjun", "password");
		// Connecting servlet with jdbc

		String query = "update registration set password = ? where email_id = ?";
		PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
		preparedStmt.setString(1, pwd);
		preparedStmt.setString(2, email);
		preparedStmt.executeUpdate();
		// Executing the sql command

		/*
		 * 
		 */
		Statement st=(Statement) conn.createStatement();
		rs=st.executeQuery("select * from registration");	
		while(rs.next())
		{
			if(email.equals(rs.getString("email_id")))
			{					
				break;
			}
		}
		session.setAttribute("data",rs);
		/*
		 * 
		 */
		PrintWriter out=res.getWriter();
		out.println("<html><head></head><body onload=\"alert('Update Successful')\"></body></html>");
		RequestDispatcher rd = req.getRequestDispatcher("EditData.jsp");
		rd.include(req, res);
		// Dispatching to the next required page
	}
	
	public void editDataName(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException {

		HttpSession session = req.getSession();
		ResultSet rs = (ResultSet) session.getAttribute("data");
		String email = rs.getString(3);
		String pwd = (String) req.getAttribute("name");
		// Setting data to process

		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn = (Connection) DriverManager.getConnection(URL, "Arjun", "password");
		// Connecting servlet with jdbc

		String query = "update registration set full_name = ? where email_id = ?";
		PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
		preparedStmt.setString(1, pwd);
		preparedStmt.setString(2, email);
		preparedStmt.executeUpdate();
		// Executing the sql command
		/*
		 * 
		 */
		Statement st=(Statement) conn.createStatement();
		rs=st.executeQuery("select * from registration");	
		while(rs.next())
		{
			if(email.equals(rs.getString("email_id")))
			{					
				break;
			}
		}
		session.setAttribute("data",rs);
		/*
		 * 
		 */
		PrintWriter out=res.getWriter();
		out.println("<html><head></head><body onload=\"alert('Update Successful')\"></body></html>");
		RequestDispatcher rd = req.getRequestDispatcher("EditData.jsp");
		rd.include(req, res);
		// Dispatching to the next required page
	}
	
	public void editDataCity(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException {

		HttpSession session = req.getSession();
		ResultSet rs = (ResultSet) session.getAttribute("data");
		String email = rs.getString(3);
		String pwd = (String) req.getAttribute("city");
		// Setting data to process

		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn = (Connection) DriverManager.getConnection(URL, "Arjun", "password");
		// Connecting servlet with jdbc

		String query = "update registration set city = ? where email_id = ?";
		PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
		preparedStmt.setString(1, pwd);
		preparedStmt.setString(2, email);
		preparedStmt.executeUpdate();
		// Executing the sql command
		/*
		 * 
		 */
		Statement st=(Statement) conn.createStatement();
		rs=st.executeQuery("select * from registration");	
		while(rs.next())
		{
			if(email.equals(rs.getString("email_id")))
			{					
				break;
			}
		}
		session.setAttribute("data",rs);
		/*
		 * 
		 */
		PrintWriter out=res.getWriter();
		out.println("<html><head></head><body onload=\"alert('Update Successful')\"></body></html>");
		RequestDispatcher rd = req.getRequestDispatcher("EditData.jsp");
		rd.include(req, res);
		// Dispatching to the next required page
	}
	
	public void editDataphone(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException {

		HttpSession session = req.getSession();
		ResultSet rs = (ResultSet) session.getAttribute("data");
		String email = rs.getString(3);
		String pwd = (String) req.getAttribute("phone");
		// Setting data to process

		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn = (Connection) DriverManager.getConnection(URL, "Arjun", "password");
		// Connecting servlet with jdbc

		String query = "update registration set phone_no = ? where email_id = ?";
		PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
		preparedStmt.setString(1, pwd);
		preparedStmt.setString(2, email);
		preparedStmt.executeUpdate();
		// Executing the sql command
		/*
		 * 
		 */
		Statement st=(Statement) conn.createStatement();
		rs=st.executeQuery("select * from registration");	
		while(rs.next())
		{
			if(email.equals(rs.getString("email_id")))
			{					
				break;
			}
		}
		session.setAttribute("data",rs);
		/*
		 * 
		 */
		PrintWriter out=res.getWriter();
		out.println("<html><head></head><body onload=\"alert('Update Successful')\"></body></html>");
		RequestDispatcher rd = req.getRequestDispatcher("EditData.jsp");
		rd.include(req, res);
		// Dispatching to the next required page
	}
	
	public boolean updateData(Model obj) throws ClassNotFoundException, SQLException
	{
		
		int ctr=0;
		String Driver="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn=(Connection) DriverManager.getConnection(URL, "Arjun","password");
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from registration");
		while(rs.next())
		{			
			if(obj.getEmail().equals(rs.getObject("email_id")))
			{
				ctr++;
			}					
		}
		if(ctr==0)
		{
			
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement("insert into registration (user_name,email_id,password) values(?,?,?)");
			ps.setString(1, obj.getUname());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getPwd());
			ps.execute();
			return true;
		}
		return false;
	}
	
	public ResultSet dispalyAdmin() throws ClassNotFoundException, SQLException
	{
		String Driver="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/Registration";
		Class.forName(Driver);
		Connection conn=(Connection) DriverManager.getConnection(URL,"Arjun","password");
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=st.executeQuery("select * from registration");
		return rs;
	}
}
