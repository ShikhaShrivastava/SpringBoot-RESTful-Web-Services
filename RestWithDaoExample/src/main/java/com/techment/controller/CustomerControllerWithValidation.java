package com.techment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dto.CustomerDto;
import com.techment.service.ICustomerService;

@RestController
@RequestMapping(value="/customerControllerValidation")
public class CustomerControllerWithValidation {

	@Autowired
	ICustomerService iCustomerService;
	
	@PostMapping(value="/insertCustomer")
	public ResponseEntity<String> addNewCustomer(@Valid @RequestBody CustomerDto customer , final BindingResult bindingResult)throws MethodArgumentNotValidException //it will throw runtime exception
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("Some Error Occur");
	    }
		iCustomerService.addCustomer(customer);
		return new ResponseEntity<String>("added new customer", HttpStatus.OK);
	}
}
