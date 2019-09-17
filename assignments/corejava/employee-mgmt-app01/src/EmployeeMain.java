import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeMain extends EmployeeService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		emplist.add(new Employee(1,"sruthy",22,"GBS","Assoc","India"));
		emplist.add(new Employee(2,"achu",19,"GBS","Assoc","UK"));
		emplist.add(new Employee(3,"sheena",40,"GBC","CEO","India"));
		


		int option = 0;
		
		while(option!=6) {
		System.out.println("Menu -");
		System.out.println("1- Add Employee\n2- View Employee\n3- Update Employee\n4- Delete Employee\n5- View All Employees");
		System.out.print("6- Exit\nEnter Your Option-");
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
		if(option==6) {
			break;
		}

	}

}
}
