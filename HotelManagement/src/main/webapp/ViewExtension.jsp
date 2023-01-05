<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "Hotel.*" import = "java.util.*" %>
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
<title>Extensions</title>
</head>
<body>
<h1 style="text-align:center"> Your Extensions </h1>
<% Room r = new Room();
int id =(int)session.getAttribute("id");
List<ExtendObject> list = r.extendlist(id);
%>
<table style="text-align:center;margin-left:auto;margin-right:auto;">
<tr>
<th>RoomNo</th>
<th>ExtendedDays</th> 
</tr>
<% for(ExtendObject s:list){ %>
<tr>
<td><% out.println(s.getRoomNo()); %></td>
<td><% out.println(s.getExtend_days()); %></td>
</tr>
<% }%>
</table>
To go to Home Page<a href="CHome.jsp">Click here</a>
</body>
</html>