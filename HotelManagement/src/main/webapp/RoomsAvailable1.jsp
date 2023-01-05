<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="Hotel.*"%>
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
<title>Availability</title>
</head>
<body >
<h1 style="text-align:center">Available Rooms are:</h1>
<div style="text-align:center">
<%
String indate = request.getParameter("indate");

Room r = new Room();
List<RoomObject> list = r.availability(indate);%>
<table style="text-align:center;margin-left:auto;margin-right:auto;">
<tr>
<th>RoomNo</th>
<th>RoomType</th>
<th>PricePerDay</th>
<th>Action</th>
</tr>
<% for(RoomObject s:list){ %>
<tr>
<td><% out.println(s.RoomNo); %></td>
<td><% out.println(s.RoomType); %></td>
<td><%out.println(s.PricePerDay); %></td>
<td><%out.println("<a href=\"Reserve.jsp?roomNo="+s.RoomNo+"&indate="+indate+"\">Reserve</a>");%>
</tr>
<% }%>
</table>
</div>
<p style="font-size:20px;">
To Go To Home page<a href = "CHome.jsp">Click here</a>
</p>
</body>
</html>