package services;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import model.Employee;

public class EmployeeService  {
	

	public static void add(ArrayList<Employee> emplist) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter empId-");
		int id=sc.nextInt();
		System.out.print("Enter name-");
		String name = sc.next();
		System.out.print("Enter age-");
		int age = sc.nextInt();
		System.out.print("Enter dept-");
		String dept = sc.next();
		System.out.print("Enter desgn-");
		String desgn = sc.next();
		System.out.print("Enter country-");
		String country = sc.next();
		emplist.add(new Employee(id,name,age,dept,desgn,country));
		
		
		
	}
	
	public static void view(int id,ArrayList<Employee> emplist) {
		System.out.println("The details-");
		int flag = 0;
				
		Iterator<Employee> itr1 = emplist.iterator();

        while (itr1.hasNext()) {
            Employee e  = itr1.next();
		if(((Employee) e).getEmpId()==id) {
		 
			System.out.println(e.toString());
			flag++;
					
		}
		}
        if(flag==0) {
        	System.out.println("Employee details of the given id does not exist");
        }
				
	}
	
	public static void viewAll(ArrayList<Employee> emplist) {
		System.out.println("Details of all Employees-");
		emplist.forEach(e->{
			System.out.println(e.toString());
		});
	}
	
	public static void delete(int id, ArrayList<Employee> emplist) {
		
		Iterator<Employee> itr1 = emplist.iterator();
		int flag = 0;
        while (itr1.hasNext()) {
            Employee e  = itr1.next();
            if(e.getEmpId()==id) {
            	itr1.remove();
            	flag++;
            }
          }
        if(flag!=0)
		System.out.println("The required employee details have been deleted");
        else
        	System.out.println("The required details doesnot exist");
						
	}
	
	public static void update(int id, ArrayList<Employee> emplist) {
		
		Iterator<Employee> itr = emplist.iterator();
		int flag = 0;
        int id1 = 0;
        while (itr.hasNext()) {
        	
            Employee e  = itr.next();
            if(e.getEmpId()==id) {
                id1 = id;
            	itr.remove();
            	flag++;
            	
        		           	
            }
          }
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter modified name-");
		String name = sc.next();
		System.out.print("Enter modified age-");
		int age = sc.nextInt();
		System.out.print("Enter modified dept-");
		String dept = sc.next();
		System.out.print("Enter modified desgn-");
		String desgn = sc.next();
		System.out.print("Enter modified country-");
		String country = sc.next();
		emplist.add(new Employee(id1,name,age,dept,desgn,country));
		
		if(flag!=0)
		System.out.println("The required employee details have been updated");
		else
			System.out.println("The required details does not exist");
						
	}
		
		
}
