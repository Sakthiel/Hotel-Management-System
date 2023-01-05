<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
p{
font-size:20px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Reserve page</title>
</head>

<body >

<h1 style="text-align:center;">Reserve Room</h1>
<div style="text-align:center;">
<form action ="Reserve1">
<p><label for="g">Enter the Room No:</label> <input type="text" name="roomNo"id="g"><br></p>
<p><label for="i">Enter the Number of Days:</label> <input type="text" name="days"id="i"><br></p>
<p><label for="j">Enter Number of persons:</label> <input type="text" name="pnum"id="j"><br></p>
<p><label for="f">Enter the CheckIn date:</label> <input type="date" name="date"id="f"><br></p>

<input type = "submit" value = "book">
</form>
</div>
</body>
</html>