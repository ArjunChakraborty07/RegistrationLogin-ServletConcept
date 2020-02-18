<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" type="text/css" href="../CSS/style.css">
<title>Insert title here</title>
</head>
<body>
<h2>Existing Member? Log In</h2>
<form action="page1b" method="post">
<br><br><br>
<p>Email ID: <input type="text" name="email" placeholder="Enter your Email Id" Required><br><br>
<p>Password: <input type="password" name="password" placeholder="Enter your Password" Required><br><br>
<p><button type="submit" value="Submit" >LogIn</button>
</form>
<div class="container" align="center">
<ul class="pagination justify-content-center" style="margin:20px 0">
  <li class="page-item"><a class="page-link" href="RegistrationPage.jsp">Previous</a></li>
  <li class="page-item"><a class="page-link" href="RegistrationPage.jsp">1</a></li>
  <li class="page-item active"><a class="page-link" href="LoginPage.jsp">2</a></li>
  <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
</ul>
</div>
</body>
</html>