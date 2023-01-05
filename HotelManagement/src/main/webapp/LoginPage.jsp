<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1 style="text-align:center"> Login Page </h1>
<div style="text-align:center">
<form action="Login" method= "post">
USERNAME:<input type="text" name ="uname"><br><br>
PASSWORD:<input type="password" name="pass"><br><br>
<input type="submit" value = "Login">
</form>
<br>

<a href="Register.jsp?type=customer"><input type="submit" value="Register"/></a>

</div>
</body>
</html>