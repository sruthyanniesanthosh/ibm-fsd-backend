package services;
import java.io.BufferedReader;
import config.EmployeeConfig;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dao.EmployeeDao;
import model.Employee;
import services.EmployeeService.MyCallable;

public class EmployeeService  {
	
	public class MyCallable implements Callable<String> {
		public  String call() throws FileNotFoundException {
			System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
			 Scanner input = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream
					 ("C:\\Training\\ibm-fsd-backend\\assignments\\employees.txt"))));
			    input.useDelimiter(",|\n");

			       while(input.hasNext()) {
			        int id = input.nextInt();
			        String name = input.next();
			        int age = input.nextInt();
			        String department = input.next();
			        String desgn = input.next();			        
			        String country = input.next();

			        Employee e2 = new Employee(id,name, age, department, desgn, country);
			        try {
						EmployeeDao.add(e2);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//throw new MyException();
			}
			System.out.println(Thread.currentThread().getName() + " -->Stop thread");
			return "End";
		}
				
	}
	
	public class MyCallableExport implements Callable<String> {
		public  String call() throws IOException {
			System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
			 
			PrintWriter out=null;
			  out = new PrintWriter(new FileWriter("C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app02\\src\\export.txt"));
			
			  ArrayList<Employee> emplist = EmployeeDao.retrieve();
			  
			  
			  
		for(int i=0;i<emplist.size();i++)
		{
			String s1= Integer.toString(emplist.get(i).getEmpId());
			String s2=emplist.get(i).getName();
			String s3=Integer.toString(emplist.get(i).getAge());
			String s4=emplist.get(i).getDept();
			String s5=emplist.get(i).getDesgn();
			String s6=emplist.get(i).getCountry();
			
			out.write(s1);
			out.write(',');
			out.write(s2);
			out.write(',');	
		    out.write(s3);
		    out.write(',');	
		    out.write(s4);
		    out.write(',');	
		    out.write(s5);
		    out.write(',');	
		    out.write(s6);
		    out.write('\n');
		}
		out.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//throw new MyException();
			}
			System.out.println(Thread.currentThread().getName() + " -->Stop thread");
			return "End";
		}
				
	}
	
	static AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
	static EmployeeDao d=(EmployeeDao) context.getBean("passDao");
	static Scanner sc = new Scanner(System.in);

	public static void add(int val) {
		try {
			Scanner sc1 = new Scanner(System.in);
//			System.out.print("Enter empId-");
//			int id=sc1.nextInt();
//			System.out.print("Enter name-");
//			String name = sc1.next();
//			System.out.print("Enter age-");
//			int age = sc1.nextInt();
//			System.out.print("Enter dept-");
//			String dept = sc1.next();
//			System.out.print("Enter desgn-");
//			String desgn = sc1.next();
//			System.out.print("Enter country-");
//			String country = sc1.next();
			Employee newEmp=(Employee)context.getBean("passEmployee");
			d.add(newEmp);
			
//			Employee e2 = new Employee(id,name,age,dept,desgn,country);
//			val = EmployeeDao.add(e2);
			System.out.println(val);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
	
	public static void view() {
		System.out.print("Enter the empId-");
		int id = sc.nextInt();
		System.out.println("The details-");
		d.view(id);
		
				
		
				
	}
	
	public static void viewAll() {
		System.out.println("Details of all Employees-");
		d.viewAll();
	}
	
	public static void delete() {
		
		System.out.print("Enter the empId-");
		int id = sc.nextInt();
		d.delete(id);
	}
	
	public static void update() {
		
		System.out.print("Enter the empId-");
		int id = sc.nextInt();
		
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter modified desgn-");
		String desgn = sc.next();
		
		d.update(id, desgn);
	}
	
	public static void importFromFile() {
	
		EmployeeService eMain = new EmployeeService();
		Callable<String> c1 = eMain.new MyCallable();
		ExecutorService e = Executors.newFixedThreadPool(1);
		Future<String> f = e.submit(c1);
		while(!f.isDone()) {
			System.out.println(Thread.currentThread().getName() + " -->Waiting");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		String s = null;
		try {
			s = f.get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Returned Value:" + s);			
	

	}
	
	public static void exportFromFile() {
		
		EmployeeService eMain2 = new EmployeeService();
		Callable<String> c2 = eMain2.new MyCallableExport();
		ExecutorService e = Executors.newFixedThreadPool(1);
		Future<String> f = e.submit(c2);
		while(!f.isDone()) {
			System.out.println(Thread.currentThread().getName() + " -->Waiting");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		String s = null;
		try {
			s = f.get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Returned Value:" + s);			
	
}
}
