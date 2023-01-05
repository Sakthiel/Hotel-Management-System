<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "Hotel.*" import="java.util.*" %>
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
<title>Customers</title>
</head>
<body>
<h1 style="text-align:center">Customers</h1>
<%List<CustObject> list; 
Room r = new Room();
list= r.cust_details();
%>
<table style="border:1px solid black;margin-left:auto;margin-right:auto;">
<tr>
<th>Customer-ID</th>
<th>Name</th>
<th>MobileNumber</th> 
<th>Gender</th> 
<th>ID-Proof</th> 
<th>Action</th>
</tr>
<% for(CustObject s:list){ %>
<tr>
<td><% out.println(s.getId()); %></td>
<td><% out.println(s.getName()); %></td>
<td><% out.println(s.getMobileNumber()); %></td>
<td><% out.println(s.getGender()); %></td>
<td><% out.println(s.getIdproof()); %></td>
<td><% out.println("<a href=\"DeleteCust1?id="+s.getId()+"\">Remove</a>");%></td>
</tr>
<% } %>
</table>
<br><br>
<p style="text-align:center;font-size:20px"> 
To add a New Customer<a href= "Register.jsp?type=admin">Click Here</a>
<br><br>
</p> 
To go to Home Page <a href = "AHome.jsp">Click here</a>
</body>
</html>