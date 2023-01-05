<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*" import="Hotel.*"%>
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
<title>Complaints</title>
</head>
<body>
<h1 style = "text-align:center">Customer Complaints</h1>
<% 
ComplaintDB c = new ComplaintDB();
List<ComplaintObject> list = c.total_complaint_list();
%>
<div>
<table style="text-align:center;margin-left:auto;margin-right:auto;">
<tr>
<th>Complaint-id</th>
<th>Category</th>
<th>Complaint</th>
<th>Status</th> 
<th>Action</th>
</tr>
<% for(ComplaintObject s:list){ %>
<tr>
<td><% out.println(s.getId()); %></td>
<td><% out.println(s.getDomain()); %></td>
<td><%out.println(s.getComplaint()); %></td>
<td><%out.println(s.getStatus()); %></td>
<td><%out.println("<a href=\"UpdateComp1?id="+s.getId()+"\">Update</a>");%></td>
</tr>
<% }%>
</table>
</div>
<br>

<a href = "AHome.jsp">Click here to go to home page</a> 
</body>
</html>