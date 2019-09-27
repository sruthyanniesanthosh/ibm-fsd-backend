<%@page import="model.Employee"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<h3>To Update Employee</h3>
<form action="updateEmployee.do" method="post">
		<label>ID: </label> <input name="id" /> <br>
		<label>Designation: </label> <input name="designation" /> <br>
		
		<button type="submit">Update</button> &nbsp; 
	</form>
	
</body>
</html>