<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.*" import = "Hotel.*" %>
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
<title>RoomType</title>
</head>
<body>
<% 
Room r = new Room();
List<revRoomType> list;
   list = r.roomIncome(); %>
<h1 style="text-align:center"> Revenue from each Room Category</h1>
<table style="border:1px solid black;margin-left:auto;margin-right:auto;">
<tr>
<th>Category</th>
<th>TotalAmount</th> 
</tr>
<% for(revRoomType s:list){ %>
<tr>
<td><% out.println(s.getRoomType()); %></td>
<td><% out.println(s.getAmount()); %></td>
</tr>
<% } %>
</table>
<br>
To Go To Home Page:<a href="AHome.jsp">Click Here</a>

</body>
</html>