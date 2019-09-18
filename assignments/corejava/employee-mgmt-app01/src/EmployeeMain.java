import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import model.Employee;
import services.EmployeeService;

public class EmployeeMain extends EmployeeService {
	
public static ArrayList<Employee> emplist = new ArrayList<Employee>();
	
	public class MyCallable implements Callable<String> {
		@Override
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
			        emplist.add(e2);}
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
		@Override
		public  String call() throws IOException {
			System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
			 
			PrintWriter out=null;
			  out = new PrintWriter(new FileWriter("C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\src\\export.txt"));

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
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		emplist.add(new Employee(1,"sruthy",22,"GBS","Assoc","India"));
		emplist.add(new Employee(2,"achu",19,"GBS","Assoc","UK"));
		emplist.add(new Employee(3,"sheena",40,"GBC","CEO","India"));
		


		int option = 0;
		
		while(option!=8) {
		System.out.println("Menu -");
		System.out.println("1- Add Employee\n2- View Employee\n3- Update Employee\n4- Delete Employee\n5- View All Employees");
		System.out.print("6- import\n7- export\n8- Exit\nEnter Your Option-");
		Scanner sc = new Scanner(System.in);
		option = sc.nextInt();
		
		if(option==1) {
			add(emplist);
		}
		
		if(option==2) {
			System.out.print("Enter the empId-");
			int id = sc.nextInt();
			view(id,emplist);
		}
		
		if(option==3) {
			System.out.print("Enter the empId-");
			int id = sc.nextInt();
			update(id,emplist);
		}
		
		if(option==4) {
			System.out.print("Enter the empId-");
			int id = sc.nextInt();
			delete(id,emplist);
		}
		
		if(option==5) {
			viewAll(emplist);
		}
		
		if(option==6)
		{
			EmployeeMain eMain = new EmployeeMain();
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
		
		if(option==7) {
			
			EmployeeMain eMain2 = new EmployeeMain();
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
		
				
		if(option==8) {
			break;
		}

	}

}
}
