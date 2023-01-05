<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.*" import = "Hotel.*"%>
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
<title>Extension</title>
</head>
<body>
<h1 style = "text-align:center"> To Extend Number of Days of Stay</h1>
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
<th>NumberOfDaysStay</th> 
</tr>
<% for(BookedRoom s:list){ %>
<tr>
<td><% out.println(s.roomNo); %></td>
<td><% out.println(s.roomType); %></td>
<td><% out.println(s.totalCost); %></td>
<td><% out.println(s.days); %></td>
</tr>
<% } %>
</table>
<div style="text-align:center">
<form action="Extension1">
<p style="font-size:20px;">
Enter the RoomNo:<input type="number" name="roomNum"><br>
Enter the number of days to be extended:<input type="number" name ="days" min="1" max="5"><br>
</p>
<input type="submit" value="Extend">
</form>
</div>

</body>
</html>