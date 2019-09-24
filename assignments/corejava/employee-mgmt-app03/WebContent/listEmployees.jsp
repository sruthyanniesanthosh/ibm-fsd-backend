<%@page import="model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Employees</title>
</head>
<body>
<h3></h3>
	<% List<Employee> employees = (List) request.getAttribute("empList");
	   out.print("No of employees: " + employees.size());
	 %>
	<h3>List Employees</h3>
	<table>
		<thead> 
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Design</td>
				<td>Department</td>
				<td>Country</td>
			</tr> 
		</thead>
		<tbody>
			<% for(Employee emp: employees) { %>
			<tr>
				<td><%= emp.getEmpId() %> </td>
				<td><%= emp.getName() %> </td>
				<td><%= emp.getDesgn() %> </td>
				<td><%= emp.getDept() %> </td>
				<td><%= emp.getCountry() %> </td>
			</tr>
			<%} %>
		</tbody>
		</tbody>
	</table>
	<br>
	<a href="index.jsp">Back to Menu</a>
</body>
</html>