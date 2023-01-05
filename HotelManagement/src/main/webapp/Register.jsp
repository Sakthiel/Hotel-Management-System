<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
form{
font-size:20px
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1 style="text-align:center"> User Registration </h1>
<div style="text-align:center">
<form action="Register1" method="post">
Enter your Name:<input type="text" name="uname" required><br><br>
Enter your password:<input type="password" name ="pass" required><br><br>
Enter your MobileNumber:<input type="tel" name="phone" placeholder="1234567890" pattern="[0-9]{10}" required><br><br>
Select your gender:&nbsp; Male: <input type="radio" name="gender" value="Male">
                    Female: <input type="radio" name="gender" value="Female">
                    ThirdGender: <input type="radio" name="gender" value="ThirdGender"><br><br>
Choose your idproof:<select name="proof">
                   <option value="aadhar">Aadhar</option>
                   <option value="DrivingLicence">DrivingLicence</option>
                   <option value="passport">Passport</option>
                   </select>
<br><br>
<input type ="hidden" name="type" value="<%= request.getParameter("type") %>">                   
<input type="submit">
</form>
</div>
</body>
</html>