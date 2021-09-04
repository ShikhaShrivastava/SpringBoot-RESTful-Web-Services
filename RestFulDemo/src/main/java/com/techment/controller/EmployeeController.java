package com.techment.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.entity.Employee;

@RestController
@RequestMapping("/employeeController")
public class EmployeeController {
	
	ArrayList<Employee>employees=new ArrayList<Employee>();
	
	
	public EmployeeController() {
		employees.add(new Employee(1,"shikha","hr"));
		employees.add(new Employee(2,"raina","developer"));

	}

	@GetMapping(value="/showmessage")
	public String dsiplay()
	{
		return "This is my first demo";
	}
	
	@GetMapping(value="/getAllEmployee")
	public ArrayList<Employee> showEmployees()
	{
		return employees;


	}
	
	@PostMapping(value="addNewEmployee")  //Anotherway to write is @RequestMapping(method=RequestMapping.POST)
	public String addEmployee(@RequestBody Employee employee)
	{
		System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getDept());
		employees.add(employee);
		return "Employee added";
	}

}
