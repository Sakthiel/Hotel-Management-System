<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="Hotel.*" %>
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
<title>Bookings</title>
</head>
<body>
<h1 style ="text-align:center;"><% 
	int num = (int) request.getAttribute("roomNo");
	int price = (int)request.getAttribute("total");
	out.println("Room Number "+ num +" is booked and Cost is "+price); %> </h1>
	<% List<BookedRoom> list;
int id = (int)session.getAttribute("id");

Room r= new Room();
list = r.booked(id);

%>
<h2 style="text-align:center;">Rooms you have booked</h2>
<table style="border:1px solid black;margin-left:auto;margin-right:auto;">
<tr>
<th>RoomNo</th>
<th>RoomType</th>
<th>Amount</th> 
</tr>
<% for(BookedRoom s:list){ %>
<tr>
<td><% out.println(s.roomNo); %></td>
<td><% out.println(s.roomType); %></td>
<td><% out.println(s.totalCost); %></td>
</tr>
<% } %>
</table>
<br><br>
<%int total = r.totalAmount(id); %>
<table  style="border:1px solid black;margin-left:auto;margin-right:auto;" >
<tr>
<th>TotalCost</th>
</tr>
<tr>
<td><% out.println(total); %></td>
</tr>
</table>
<p style = "text-align:center;font-size:20px"> To Cancel Booking<a href = "Cancel.jsp">Click here</a> </p> <br>
<a href="CHome.jsp">Click here to go to homepage</a>
</body>
</html>