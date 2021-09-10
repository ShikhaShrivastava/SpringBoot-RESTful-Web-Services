package com.techment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dto.CustomerDto;
import com.techment.entity.Customer;
import com.techment.exception.IDNotFoundException;
import com.techment.service.ICustomerService;

@RestController
@RequestMapping(value="/customerController")
public class CustomerController {

	@Autowired
	ICustomerService iCustomerService;
	
	@GetMapping("/viewAllCustomer")
	public List<CustomerDto> viewCustomer(@RequestHeader String token)
	{
		return iCustomerService.viewAllCustomers();
	}
	@PostMapping(value="/insertCustomer")
	public String addNewCustomer(@Valid @RequestBody CustomerDto customer, BindingResult bindingResult) throws MethodArgumentNotValidException //it will throw runtime exception
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("Some Error Occur");
			List<FieldError> fieldError=bindingResult.getFieldErrors();   //binding result will bind all the error as link and give it to exception handler to handle.
			List<String> errorList = new ArrayList<String>();   
			for(FieldError f : fieldError)
			{
				errorList.add(f.getDefaultMessage());
			}
			throw new com.techment.exception.ValidationException(errorList);
		}
		iCustomerService.addCustomer(customer);
		return "Inserted";
	}
	@GetMapping(value="/customerById")
	public CustomerDto getById(@PathVariable int id)
	{
//		CustomerDto customer= iCustomerService.viewCustomerById(id);
//		return customer;
		try {
			CustomerDto customer= iCustomerService.viewCustomerById(id);
		return customer;
		 } 
	catch (NoSuchElementException e) 
		{
			throw new IDNotFoundException("NO id present to get it");
		}
	}
	
//	@ExceptionHandler(value=IDNotFoundException.class)
//	public ResponseEntity<Object>myException(IDNotFoundException exception)
//	{
//		return new ResponseEntity<Object>(exception.getMsg(), HttpStatus.NOT_FOUND);
//		
//	}   ----------------->Declared globally in separate package
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("id") int id, @RequestBody CustomerDto customer)
	{
		return  new ResponseEntity<Object>(iCustomerService.updateCustomer(customer, id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public  ResponseEntity<Object> updateCustomer(@PathVariable("id") int id)
	{
		iCustomerService.deleteCustomer(id);
		return  new ResponseEntity<Object>("Customer Deleted", HttpStatus.OK);

	}
	
}
