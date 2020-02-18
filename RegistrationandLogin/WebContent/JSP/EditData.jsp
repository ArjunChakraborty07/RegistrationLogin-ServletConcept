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
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../CSS/style.css">

<title>Edit Page</title>
</head>
<body>

<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
<h2>Welcome to edit Page</h2>
<form action="editfn" method="post">
Full Name:<input type="text" name="name" required>
<button type="submit" value="submit">Update</button><br><br>
</form>
<form action="editpn" method="post">
Phone Number:<input type="text" name="phone" required>
<button type="submit" value="submit">Update</button><br><br>
</form>
<form action="editc" method="post">
City:<input type="text" name="city" required>
<button type="submit" value="submit">Update</button><br><br>
</form>
<form action="editpd" method="post">
Update Password:<input type="password" name="password" required>
<button type="submit" value="submit">Update</button><br><br>
</form>
<div class="container" align="center"> 
<form action="page2a" method="post">
<button type="submit" class="btn btn-secondary" name="account" value="account">ACCOUNT</button><br><br>
</form>
</div>
</body>
</html>