<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import ="Hotel.*"%>
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
<title>Cancel</title>
</head>
<body>
<h1 style="text-align:center;">Cancel page</h1> 

<% List<BookedRoom> list;
int id = (int)session.getAttribute("id");
System.out.println(id);
Room r= new Room();
list = r.booked(id);

%>
<h2 style="text-align:center;">Rooms you have booked</h2>
<table style="border:1px solid black;margin-left:auto;margin-right:auto;">
<tr>
<th>RoomNo</th>
<th>RoomType</th>
<th>TotalAmount</th>
<th>Action</th> 
</tr>
<% for(BookedRoom s:list){ %>
<tr>
<td><% out.println(s.roomNo); %></td>
<td><% out.println(s.roomType); %></td>
<td><% out.println(s.totalCost); %></td>
<td><%out.println("<a href=\"ToCancel1?roomNum="+s.roomNo+"\">Cancel</a>");%>
</tr>
<% } %>
</table>
<br><br>

<div style="text-align:center;">
</div>
</body>
</html>