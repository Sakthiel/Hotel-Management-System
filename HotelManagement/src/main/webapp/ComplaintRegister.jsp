<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
form{
font-size:20px
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Portal</title>
</head>
<body>
<h1 style="text-align:center">Complaints Forum</h1>
<h2>Here you can post your complaints which will be rectified by us.</h2>
<form action="Complaint1">
<p style="font-size:20px">Select a domain given below </p>
<input type="radio" name="domain" value = "delivery"> Delivery <br>
<input type="radio" name="domain" value = "food"> Food <br>
<input type="radio" name="domain" value = "RoomService"> RoomService<br>
<input type="radio" name="domain" value = "other"> other <br>
Complaint:<br>
<textarea name="complaint" rows="5" cols="50">

</textarea> 

<input type="submit">
</form>
To View Your Complaints<a href="ViewComplaints.jsp">Click here</a>
</body>
</html>