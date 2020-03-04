package com.bridgelabz.service;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.Model;



public interface Service {

	public void deleteData(HttpServletRequest req, HttpServletResponse res);
	public  void editDataPassword(HttpServletRequest req, HttpServletResponse res);
	public void editDataName(HttpServletRequest req, HttpServletResponse res);
	public void editDataCity(HttpServletRequest req, HttpServletResponse res);			
	public void editDataphone(HttpServletRequest req, HttpServletResponse res);			
	public boolean updateData(Model obj); 
	public ResultSet dispalyAdmin();
}
