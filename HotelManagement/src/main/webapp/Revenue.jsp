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
<title>Revenue</title>
</head>
<body>
<h1 style="text-align:center;font-size:50px">Hotel Revenue</h1>
<%
Room r = new Room();
List <IncomeObj> list = r.cincome();
%>
<h3 style="text-align:center;font-size:30px"> Revenue from each Customer </h3>
<table style="text-align:center;margin-left:auto;margin-right:auto;">
<tr>
<th>Customer-ID</th>
<th>Name</th>
<th>Cost</th>
</tr>
<% for(IncomeObj s:list){ %>
<tr>
<td><%=s.getId()%></td>
<td><% out.println(s.getName()); %></td>
<td><%out.println(s.getCost()); %></td>
</tr>
<% }%>

</table>
<br><br>
<%
int total;
total = r.totalRevenue();
%>
<h3 style="text-align:center;font-size:30px">Total Revenue of the hotel</h3>
<table style="text-align:center;margin-left:auto;margin-right:auto;">
<tr>
<th> Total Revenue</th>
</tr>
<tr>
<td><% out.println(total); %></td>
</tr>
</table>
<br><br>
<p style = "text-align:center;font-size:20px">
To View Revenue from each Room Type:<a href="RevenueByType.jsp">Click here</a>
</p>
To go to Home Page<a href = "AHome.jsp"> Click Here</a>

</body>
</html>