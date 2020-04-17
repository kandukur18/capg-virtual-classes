<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person Details</title>
</head>
<body style="margin-left: 600px;margin-top: 100px">
      <h2>Person Details</h2> 
   <table border="2">
     <tr><td><strong>User Name</strong></td><td>${person.userName }</td></tr>
     <tr><td><strong>User ID</strong></td><td>${person.userId }</td></tr>
     <tr><td><strong>Date Of Birth</strong> </td><td>${person.date }</td></tr>
     <tr><td><strong>Email</strong> </td><td>${person.emailId }</td></tr>
     <tr><td><strong>Age</strong> </td><td>${person.age }</td></tr>
   </table>
</body>
</html>