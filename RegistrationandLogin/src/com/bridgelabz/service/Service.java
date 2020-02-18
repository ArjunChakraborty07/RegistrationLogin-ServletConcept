package com.bridgelabz.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.Model;



public interface Service {

	public void deleteData(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException, ServletException, IOException; 
	public ResultSet dispalyData(Model obj) throws ClassNotFoundException, SQLException;
	public  void editDataPassword(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException;
	public void editDataName(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException;
	public void editDataCity(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException;
	public void editDataphone(HttpServletRequest req, HttpServletResponse res)
			throws ClassNotFoundException, SQLException, ServletException, IOException;
	public boolean updateData(Model obj) throws ClassNotFoundException, SQLException;
	public ResultSet dispalyAdmin() throws ClassNotFoundException, SQLException;
}
