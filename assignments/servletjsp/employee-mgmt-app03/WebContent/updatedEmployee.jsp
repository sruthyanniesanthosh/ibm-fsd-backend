<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updated</title>
</head>
<body>
	<% int emp =(Integer)request.getAttribute("emp");
	if(emp!=0){
	  
	 %>
	 <h3>The record has been updated<h3>
	 <%}else{ %>
	 <h3>The record has not been updated or does not exist</h3>
	 <%} %>
	 <p>
	 <a href="listEmployees.do">View Employees</a><br>
	 	 <a href="index.jsp">Back to Menu</a>
	 </p>

</body>
</html>