package com.examples.empapp.config;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.service.EmployeeService;
import com.mysql.jdbc.Connection;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples.empapp")
public class CustomDispatcherConfig {

	@Bean
	public EmployeeService empService() {
		return new EmployeeService();
	}
	
	@Bean
	public EmployeeDao empDao() {
		return new EmployeeDao();
	}
	
	@Bean
	public java.sql.Connection connection() throws ClassNotFoundException, SQLException {
		java.sql.Connection conn = null;
		
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctraining", "training", "training");
		
		
		return conn;
	}
	
	

}
