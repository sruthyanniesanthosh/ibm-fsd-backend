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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import dao.EmployeeDao;
import model.Employee;
import services.EmployeeService;

public class EmployeeMain extends EmployeeService {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int val = 0;
		int option = 0;
		
		while(option!=8) {
		System.out.println("Menu -");
		System.out.println("1- Add Employee\n2- View Employee\n3- Update Employee\n4- Delete Employee\n5- View All Employees");
		System.out.print("6- import\n7- export\n8- Exit\nEnter Your Option-");
		Scanner sc = new Scanner(System.in);
		option = sc.nextInt();
		
		if(option==1) {
			add(val);
			
		}
		
		if(option==2) {
			
			view();
			
		}
		
		if(option==3) {
			
			update();
		}
		
		if(option==4) {
			
			delete();
			
		}
		
		if(option==5) {
			viewAll();
			
		}
		
		if(option==6)
		{
			importFromFile();
		}
		
		if(option==7) {
			
			exportFromFile();
						}
		
				
		if(option==8) {
			break;
		}

	
}
}
}