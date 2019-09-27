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

@WebServlet("/deleteEmployee.do")
public class DeleteEmployeeController extends HttpServlet{
	
EmployeeService empService = new EmployeeService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String val = req.getParameter("input2");
		int id = Integer.parseInt(val);
		int employee = EmployeeDao.delete(id);
		
		System.out.println(employee);
		
		req.setAttribute("emp", employee);
		
		RequestDispatcher rd = req.getRequestDispatcher("deleteEmployee.jsp");
		rd.forward(req, resp);
	}


}
