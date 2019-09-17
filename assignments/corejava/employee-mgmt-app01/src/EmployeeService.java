import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
		emplist.forEach(e->
		{if(((Employee) e).getEmpId()==id) {
						
			System.out.println(e.toString());}});
		
		
	}
	
	public static void viewAll(ArrayList<Employee> emplist) {
		System.out.println("Details of all Employees-");
		emplist.forEach(e->{
			System.out.println(e.toString());
		});
	}
	
	public static void delete(int id, ArrayList<Employee> emplist) {
		
		Iterator<Employee> itr1 = emplist.iterator();

        while (itr1.hasNext()) {
            Employee e  = itr1.next();
            if(e.getEmpId()==id) {
            	itr1.remove();
            }
          }

		System.out.println("The required employee details have been deleted");
						
	}
	
	public static void update(int id, ArrayList<Employee> emplist) {
		
		Iterator<Employee> itr = emplist.iterator();

        int id1 = 0;
        while (itr.hasNext()) {
        	
            Employee e  = itr.next();
            if(e.getEmpId()==id) {
                id1 = id;
            	itr.remove();
            	
        		           	
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
		

		System.out.println("The required employee details have been updated");
						
	}
		
		
	
}
