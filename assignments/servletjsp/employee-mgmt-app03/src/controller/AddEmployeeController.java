package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;
import services.EmployeeService;

@WebServlet("/addEmployee.do")
public class AddEmployeeController extends HttpServlet{
	
	EmployeeService empService = new EmployeeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Integer age= Integer.parseInt(req.getParameter("age"));
		String designation = req.getParameter("designation");
		String department = req.getParameter("department");
		String country = req.getParameter("country");
		
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Designation: " + designation);
		System.out.println("Departememt: " + department);
		System.out.println("Country: " + country);
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.setAge(age);
		emp.setDesgn(designation);
		emp.setDept(department);
		emp.setCountry(country);

		try {
			EmployeeDao.add(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Employee created successfully.");
		
		RequestDispatcher rd = req.getRequestDispatcher("listEmployees.do");
		rd.forward(req, resp);
	}

}
