<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservepage</title>
</head>

<body >

<h1 style="text-align:center;">Reserve Room</h1>
<div style="text-align:center;">
<form action ="Reserve1">
<input type="hidden" name="roomNo" value="<%=request.getParameter("roomNo")%>" ><br>
<p style="font-size:20px;"><label for="i">Enter the Number of Days:</label> <input type="number" name="days"id="i" min="1" max="10"><br></p>
<p style="font-size:20px;"><label for="j">Enter Number of persons:</label> <input type="number" name="pnum"id="j" min="1" max="4"><br></p>
<input type="hidden" name="date" value="<%=request.getParameter("indate")%>" ><br>
<input type = "submit" value = "book">
</form>
</div>
</body>
</html>