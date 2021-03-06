package com.techment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.IEmployeeDao;
import com.techment.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	IEmployeeDao iEmployeeDao;
	
	@Override
	public String addEmployee(Employee employee) {
		iEmployeeDao.save(employee);
		return "Employee Added";
	}

	@Override
	public List<Employee> viewAllEmployees() {
		return iEmployeeDao.findAll();
	}
	
	@Override
	public Employee viewEmployeeById(int id)
	{
		return 	iEmployeeDao.findById(id).get();
	}

}
