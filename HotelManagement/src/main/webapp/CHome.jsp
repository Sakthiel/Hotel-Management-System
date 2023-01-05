<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
table,th,td {
  border:1px solid black;
  font-size:20px;
  
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%request.setAttribute("from","customer"); %>
<h1 style ="text-align:center;">Click Any Of The Option Below To Avail Service</h1>


<table style="margin-top:10px;margin-left:auto;margin-right:auto;">
<tr>
<td>To See Available Room:</td> <td><a href="CheckIn.jsp">Click here</a> </td>
</tr>
<tr>
<td>To Cancel Room:</td> <td><a href ="Cancel.jsp">Click here</a></td>
</tr>
<tr>
<td>To Extend Room:</td> <td><a href ="RoomExtension.jsp">Click here</a></td>
</tr>
<tr>
<td>To View Your Bookings: </td><td><a href = "ViewBookingHome.jsp">Click here</a></td>
</tr>
<tr>
<td>To Register for a Complaint:</td> <td><a href = "ComplaintRegister.jsp"> Click here </a></td>
</tr>
</table>
<form action = "LogOut1">
To logout:<br>
<input type = "submit" value="logout">
</form>
</body>
</html>