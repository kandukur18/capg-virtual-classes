<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body style="margin-left: 600px;margin-top: 100px">
<h2 >Form </h2>
<form action="add" method="POST">
   <table>
      <tr><td>UserName </td><td><input type="text" name="userName"></td></tr>
      <tr><td>User ID</td><td><input type="number" name="userId"></td></tr>
      <tr><td>Email</td><td><input type="email" name="emailId"></td></tr>
      <tr><td>Date Of Birth</td><td><input type="date" name="date"></td></tr>  
      <tr><td><button type="submit">Submit</button></td></tr> 
   </table>
</form>
</body>
</html>