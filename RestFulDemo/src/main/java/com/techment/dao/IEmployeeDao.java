package com.techment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techment.entity.Employee;

@Repository
public interface IEmployeeDao  extends JpaRepository<Employee, Integer>{

}
