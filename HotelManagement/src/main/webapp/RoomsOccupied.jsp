<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import = "Hotel.*" %>
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
<title>Occupancy</title>
</head>
<body>
<h1 style="text-align:center">Occupancy of Rooms</h1>
<%Room r = new Room();
List<CObject> list = r.occupiedlist();%>


<table style="text-align:center;margin-left:auto;margin-right:auto;">
<tr>
<th>Customer-id</th>
<th>Name</th>
<th>RoomNo</th> 
<th>RoomType</th>
<th>NumberOfPersons</th>
</tr>
<% for(CObject s:list){ %>
<tr>
<td><% out.println(s.getid()); %></td>
<td><% out.println(s.getname()); %></td>
<td><%out.println(s.getroomNum()); %></td>
<td><%out.println(s.getroomType()); %></td>
<td><%out.println(s.getnum()); %></td>
</tr>
<% }%>
</table>
<p style="text-align:center;font-size:20px">
To get CheckIn and CheckOut Dates<a href = "CheckOut.jsp">Click Here</a> </p><br>
To Go to Home Page:<a href="AHome.jsp">Click Here</a>

</body>
</html>