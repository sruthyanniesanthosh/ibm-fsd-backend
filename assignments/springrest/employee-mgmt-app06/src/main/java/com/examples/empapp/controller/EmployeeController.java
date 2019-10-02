package com.examples.empapp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public List getAllEmployees(){
		
		return empService.viewAll();
	}
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empService.view(id);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public int createEmployee(@RequestBody Employee employee) {
		int status = empService.add(employee);
		return status;
		
	}
	
	@PutMapping(value ="/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public boolean update(@PathVariable int id ,@RequestBody Employee employee) {
		boolean status = empService.update(id, employee);
		return status;
		
	}
	
	@DeleteMapping(value = "/{id}")
	public int delete(@PathVariable int id) {
		int status = empService.delete(id);
		return status;
	}
	
	
}
