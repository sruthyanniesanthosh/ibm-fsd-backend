package config;
import java.util.Scanner;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import dao.EmployeeDao;
import model.Employee;

@Configuration
public class EmployeeConfig {

	@Lazy
	@Bean
public Employee passEmployee() {
		
		Scanner sc1=new Scanner(System.in);
		System.out.print("Enter empId-");
		int id=sc1.nextInt();
		System.out.print("Enter name-");
		String name = sc1.next();
		System.out.print("Enter age-");
		int age = sc1.nextInt();
		System.out.print("Enter dept-");
		String dept = sc1.next();
		System.out.print("Enter desgn-");
		String desgn = sc1.next();
		System.out.print("Enter country-");
		String country = sc1.next();
		Employee newEmp = new Employee(id, name, age, dept,desgn, country);
		return newEmp;
	}
	
//	@Lazy
//	@Bean
//	public Employee passUpdateEmployee() {
//		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("passEmployee Enter Id:");
//		int nId=sc.nextInt();
//		System.out.println("Enter Name:");
//		String nName=sc.next();
//		System.out.println("Enter Age:");
//		int nAge=sc.nextInt();
//		System.out.println("Enter Designation:");
//		String nDesign=sc.next();
//		System.out.println("Enter Department:");
//		String nDept=sc.next();
//		System.out.println("Enter Country:");
//		String nCountry=sc.next();
//		Employee newEmp = new Employee(0, nName,nAge, nDesign, nDept, nCountry);
//		return newEmp;
//	}
	
	@Bean
	public EmployeeDao passDao() {
		return new EmployeeDao();
	}
	
	
	
}
