<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Hotel.*" import = "java.util.*" %>
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
<title>RoomDetails</title>
</head>
<body>
<h1 style="text-align:center"> Hotel Rooms</h1>
<% Room r= new Room(); 
List<RoomObject> list = r.roomdetails();
%>
<table style="text-align:center;margin-left:auto;margin-right:auto;">
<tr>
<th>RoomNo</th>
<th>RoomType</th>
<th>PricePerDay</th>
<th>Status</th>
<th>Actions</th> 
</tr>
<% for(RoomObject s:list){ %>
<tr>
<td><% out.println(s.RoomNo); %></td>
<td><% out.println(s.RoomType); %></td>
<td><%out.println(s.PricePerDay); %></td>
<td><%out.println(s.status); %></td>
<td><%out.println("<a href=\"Remove?roomNum="+s.RoomNo+"\">Delete</a>");%></td>
</tr>
<% }%>
</table>
<br>
<p style ="text-align:center;font-size:20px">
To add a New Room:<a href = "AddRoom.jsp">ClickHere</a><br>
</p>
To Go To Home Page:<a href = "AHome.jsp">ClickHere</a> 
<br>
</body>
</html>