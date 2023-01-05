<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="Hotel.*" import = "java.util.*"%>
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
<title>Dates</title>
</head>
<body>
<h1 style="text-align:center">CheckIn and CheckOut Dates</h1>
<%Room r = new Room();
List<DateObject> list = r.inoutdates();%> 
<table style="text-align:center;margin-left:auto;margin-right:auto;">
<tr>
<th>Customer-ID</th>
<th>RoomNo</th>
<th>CheckIN</th> 
<th>CheckOUT</th> 
</tr>
<% for(DateObject s:list){ %>
<tr>
<td><% out.println(s.getId()); %></td>
<td><% out.println(s.getRoomNo()); %></td>
<td><%out.println(s.getCheckIn()); %></td>
<td><%out.println(s.getCheckOut()); %></td>
</tr>
<% }%>
</table>
To Go To Home Page<a href="AHome.jsp">Click here</a>



</body>
</html>