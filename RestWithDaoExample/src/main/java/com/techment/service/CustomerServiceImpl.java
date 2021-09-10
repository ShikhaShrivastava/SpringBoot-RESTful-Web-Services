package com.techment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.ICustomerDao;
import com.techment.dto.CustomerDto;
import com.techment.entity.Customer;
import com.techment.exception.IDNotFoundException;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao iCustomerDao;
	
	@Override
	public String addCustomer(CustomerDto customerDto) {
		Customer customer= new Customer();
		customer.setName(customerDto.getName());
		customer.setAddress(customerDto.getAddress());
		customer.setAge(customerDto.getAge());
		customer.setEmail(customerDto.getEmail());
		iCustomerDao.save(customer);
		return "Customer is Added";
	}

	@Override
	public List<CustomerDto> viewAllCustomers() {
		List<Customer>customers= iCustomerDao.findAll();
		List<CustomerDto> customerDto= new ArrayList<CustomerDto>();
		for(Customer c :customers)
		{
			customerDto.add(new CustomerDto(c.getId(), c.getName(),c.getAge(),c.getAddress()));
		}
		return customerDto;
	}

	@Override
	public CustomerDto viewCustomerById(int id) throws NoSuchElementException{
		Customer customer= iCustomerDao.findById(id).get();
		CustomerDto customerDto= new CustomerDto(customer.getId(), customer.getName(),customer.getAge(),customer.getAddress(),customer.getEmail(),customer.getMobile());
		
		return customerDto;
	}

	@Override
	public String updateCustomer(CustomerDto customerDto, int id) throws NoSuchElementException {
		Customer existingCustomer= iCustomerDao.findById(id).get();
		existingCustomer.setName(customerDto.getName());
		existingCustomer.setAge(customerDto.getAge());
		existingCustomer.setAddress(customerDto.getAddress());
		existingCustomer.setEmail(customerDto.getEmail());
		iCustomerDao.save(existingCustomer);
		return "Customer updated";


	}

	@Override
	public void deleteCustomer(int id) {
		iCustomerDao.deleteById(id);
	}

}
