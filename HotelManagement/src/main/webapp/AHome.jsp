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
<title>Admin</title>
</head>
<body>
<% request.setAttribute("from","admin"); %>
<h1 style="text-align:center">Admin Page</h1>


<table style="margin-top:10px;margin-left:auto;margin-right:auto;">
<tr>
<td>To View Customer Details :</td> <td><a href="CustomerDetails.jsp">Click here</a> </td>
</tr>
<tr>
<td>To View Room Details:</td><td><a href ="RoomDetails.jsp"> Click here </a> </td>
</tr>
<tr>
<td>To View Occupancy of the Rooms:</td> <td><a href ="RoomsOccupied.jsp">Click here</a></td><br><br>
</tr>
<tr>
<td>To View Complaints:</td> <td><a href ="AViewComplaints.jsp">Click here</a></td><br><br>
</tr>
<tr>
<td>To View Revenue of Hotel:</td> <td><a href ="Revenue.jsp">Click here</a></td><br><br>
</tr>
</table>




<br>
<a href="LogOut1"><input type="submit" value="logout"/></a>
</body>
</html>