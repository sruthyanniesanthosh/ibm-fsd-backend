<%@page import="model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body>
<h3>To view Employee</h3>
<% Employee emp =(Employee) request.getAttribute("emp");
	  
	 %>
	<h3>List Employees</h3>
	<table>
		<thead> 
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Desgn</td>
				<td>Dept</td>
				<td>Country</td>
			</tr> 
		</thead>
		<tbody>
						<tr>
				<td><%= emp.getEmpId() %> </td>
				<td><%= emp.getName() %> </td>
				<td><%= emp.getDesgn() %> </td>
				<td><%= emp.getDept() %> </td>
				<td><%= emp.getCountry() %> </td>
				
			</tr>
		</tbody>
		</tbody>
	</table>
	<br>
		 <a href="index.jsp">Back to Menu</a>
</body>
</html>