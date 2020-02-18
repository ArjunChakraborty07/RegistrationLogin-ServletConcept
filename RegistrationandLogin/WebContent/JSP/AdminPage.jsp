<!DOCTYPE html>
<html>
<%@page import="com.bridgelabz.service.*"%>
<%@page import="com.bridgelabz.databaseoperations.*"%>
<%@page import="com.bridgelabz.model.*"%>
<%@page import="com.bridgelabz.controller.*"%>
<%@page import="java.sql.*"%>
  
<head>
  <title>DataBase</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>
<h2>Data Base</h2>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">UserName</th>
      <th scope="col">Email Id</th>
      <th scope="col">Full Name</th>
      <th scope="col">City</th>
      <th scope="col">Phone Number</th>
    </tr>
  </thead>
<%
int check;
ResultSet rs=(ResultSet)session.getAttribute("admin");
while(rs.next())
{	
%>

  <tbody>
    <tr>
      <th scope="row"><%=rs.getRow()%></th>
      <td><%=rs.getString("user_name")%></td>
      <td><%=rs.getString("email_id")%></td>
      <td><%=rs.getString("full_name")%></td>
      <td><%=rs.getString("city")%></td>
      <td><%=rs.getString("phone_no")%></td>
    </tr>
  </tbody>

<%
if(rs.getRow()%2==0)
break;
}
%>

</table>
<div class="container" align="center">
<form action="admin" method="post">
<button type="submit" name="button" value="admin" class="btn btn-primary" >ACCOUNT</button>
</form>
</div>

<%

if(rs.getRow()==2)
	{
%>
<div class="container" align="center">
<ul class="pagination justify-content-center" style="margin:20px 0">
  <li class="page-item disabled"><a class="page-link" href="AdminPage2.jsp">Previous</a></li>
  <li class="page-item" ><a class="page-link" href="AdminPage.jsp">Next</a></li>
</ul>
</div>
<%
	}

 else if(rs.isAfterLast())
	{ 
%>
<div class="container" align="center">
  <ul class="pagination justify-content-center" style="margin:20px 0">
    <li class="page-item" ><a class="page-link" href="AdminPage2.jsp">Previous</a></li>
    <li class="page-item disabled"><a class="page-link" >Next</a></li>
  </ul>
</div> 
<%
	} 
 else
	{
%>
<div class="container" align="center">
  <ul class="pagination justify-content-center" style="margin:20px 0">
	<li class="page-item" ><a class="page-link" href="AdminPage2.jsp">Previous</a></li>
	<li class="page-item" ><a class="page-link" href="AdminPage.jsp">Next</a></li>
  </ul>
</div>
<%
	}
%>

</body>
</html>

