<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management App</title>
</head>
<body>
	<h2> Welcome to Employee Management App! </h2>
	<h3>Menu-</h3>
	<p>
	<a href="listEmployees.do">View Employees</a><br>
	
	<a href="addEmployee.jsp">Add Employee</a>
	<br>
	
	<form action= "listEmployee.do" method="get">
	<a href="" >View Employee By Id</a><br>
	<input id = "input" type= text name="input" ></input>
	<button type="submit">View</button>
	</form>
	<form action= "deleteEmployee.do" method="get">
	<a href="" >Delete Employee By Id</a><br>
	<input id = "input2" type= text name="input2" ></input>
	<button type="submit">Delete</button>
	</form>
	
	
	<a href="updateEmployee.jsp" >Update Employee By Id</a>
	<br>
	</p>
</body>
</html>