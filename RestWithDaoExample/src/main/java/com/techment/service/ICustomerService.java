package com.techment.service;

import java.util.List;

import com.techment.dto.CustomerDto;
import com.techment.entity.Customer;

public interface ICustomerService {
	String addCustomer(CustomerDto customerDto);
	
	List<CustomerDto> viewAllCustomers();
	
	CustomerDto viewCustomerById(int id);
	
	String updateCustomer(CustomerDto customerDto,int id);
	
	void deleteCustomer(int id);
}
