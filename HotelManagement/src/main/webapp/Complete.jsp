<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="Hotel.*"%>
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
<title>Status</title>
</head>
<body>
<h1 style="text-align:center;">
<% if (request.getAttribute("type").equals("reserve")){
	int num = (int) request.getAttribute("roomNo");
	int price = (int)request.getAttribute("total");
	out.println("Room Number "+ num +" is booked and Cost is "+price);}
	
     if (request.getAttribute("type").equals("cancel")){
		int num = (int)request.getAttribute("roomNum");
		out.println("Your Booking of Room number "+num+" is cancelled");
		int id = (int)session.getAttribute("id");
        Room r= new Room();
		int total = r.totalAmount(id);%>
<table style="border:1px solid black;margin-left:auto;margin-right:auto;">
<tr>
<th>NewTotalCost</th>
</tr>
<tr>
<td><% out.println(total); %></td>
</tr>
</table>
<% }%>
    
     
     <% if (request.getAttribute("type").equals("reserve")){
    	 RequestDispatcher rd = request.getRequestDispatcher("ViewBooking.jsp");
 		rd.forward(request,response);
     }
     
	if (request.getAttribute("type").equals("noreserve")){
		out.println("Room is not available");}
	if (request.getAttribute("type").equals("extend")){
		out.println("Stay period is Extended for "+request.getAttribute("period")+" days"+
	" and New Cost is "+request.getAttribute("cost"));
		out.println("<br>");
		out.println("<a style=\"font-size:70%;\"href=\"ViewExtension.jsp\">Click here to view your Extensions</a>");}
	if (request.getAttribute("type").equals("complaint")){
		out.println("Your Complaint has been filed successfully <br><br>");
		out.println("<a style=\"font-size:70%;\"href=\"ViewComplaints.jsp\">Click here to view your Complaints</a><br><br>");}
	
%>
</h1>

<a href="CHome.jsp">Click here to go to homepage</a>

</body>
</html>