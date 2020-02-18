<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bridgelabz.service.*"%>
<%@page import="com.bridgelabz.databaseoperations.*"%>
<%@page import="com.bridgelabz.model.*"%>
<%@page import="com.bridgelabz.controller.*"%>
<%@page import="java.sql.*"%>


<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%



  	session=request.getSession();
    ResultSet rs=(ResultSet)session.getAttribute("data");  
    String email=(String)session.getAttribute("check");
%>
<div class="container">
  <h2>Welcome <%=rs.getString("user_name") %></h2>
  <p>YOUR DATA</p>                                                  
  <table class="table">
    <thead>
      <tr>
        <th>Index</th>
        <th>Data</th>
      </tr>
    </thead>
    <tbody>
      <tr class="success">
        <td>User Name:</td>
        <td><%= rs.getString(2)%></td>
      </tr>
      <tr>
        <td>Email Id:</td>
        <td><%= rs.getString(3)%></td>
      </tr>
      <tr class="success">
        <td>Full Name:</td>
        <td><%= rs.getString(4)%></td>
      </tr>
      <tr>
      	<td>City:</td>
      	<td><%= rs.getString(5)%></td>
      </tr>	
      <tr class="success">
      	<td>Phone no:</td>
      	<td><%= rs.getString(6)%></td>
      </tr>	
    </tbody>
  </table>
 </div> 
  
<div class="container" align="center">  
<form action="page2" method="post">            
    <button type="submit" name="button" value="logout" class="btn btn-danger">LOGOUT</button> 
    <button type="submit" name="button" value="edit" class="btn btn-info" >EDIT</button> 
    <button type="submit" name="button" value="delete" class="btn btn-warning" >DELETE ACCOUNT</button>  
    <%if(email.equals("chakraborty.arjun6@gmail.com"))
      {%>
    	<button type="submit" name="button" value="admin" class="btn btn-primary" >ADMIN PAGE</button>
    <%}
    
    %>	
</form>
</div>

</body>
</html>




