package com.techment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.entity.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Integer>{

}
