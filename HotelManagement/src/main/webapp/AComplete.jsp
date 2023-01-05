<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status</title>
</head>
<body>
<h1 style="text-align:center">
<% 
if (request.getAttribute("process").equals("addcustomer")){
	out.println("Customer "+request.getAttribute("name")+" is Registered successfully");
	out.println("<br><br>");
	out.println("<a style=\"font-size:60%;\"href=\"CustomerDetails.jsp\">Click here to view Updated Customers List</a><br><br>");}
if (request.getAttribute("process").equals("deletecustomer")){
	out.println("Customer "+request.getAttribute("name")+" is Removed successfully");
	out.println("<br><br>");
	out.println("<a style=\"font-size:60%;\"href=\"CustomerDetails.jsp\">Click here to view Updated Customers List</a><br><br>");}

if (request.getAttribute("process").equals("addroom")){
	   
		out.println("Room of type "+request.getAttribute("roomType")+" with price "+request.getAttribute("price")+
				" is added successfully");
		out.println("<br><br>");
		out.println("<a style=\"font-size:60%;\"href=\"RoomDetails.jsp\">Click here to view Updated Room List</a><br><br>");
}

if (request.getAttribute("process").equals("deleteroom")){
	out.println("Room Number "+ request.getAttribute("roomNo")+"("+request.getAttribute("roomType")+") is deleted successfully");
	out.println("<br><br>");
	out.println("<a style=\"font-size:60%;\"href=\"RoomDetails.jsp\">Click here to view Updated Room List</a><br><br>");
}

if(request.getAttribute("process").equals("updateComplaint")){
	out.println("Complaint Number "+request.getAttribute("id")+" is Processed Successfully");
	out.println("<br><br>");
	out.println("<a style=\"font-size:60%;\"href=\"AViewComplaints.jsp\">Click here to view Updated Complaint List</a><br><br>");
}
%>
</h1>
<a href = "AHome.jsp">Click here to go to home page</a>
</body>
</html>