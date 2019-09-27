package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import services.EmployeeService;

@WebServlet("/updateEmployee.do")
public class UpdateEmployeeController extends HttpServlet {
	
EmployeeService empService = new EmployeeService();
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	this.doPost(req, resp);
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String designation = req.getParameter("designation");
		Integer id = Integer.parseInt(req.getParameter("id"));
		int employee = EmployeeDao.update(id, designation);
		System.out.println(employee);
		
		req.setAttribute("emp", employee);
		
		RequestDispatcher rd = req.getRequestDispatcher("updatedEmployee.jsp");
		rd.forward(req, resp);

}
}