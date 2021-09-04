package com.techment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.entity.Author;


public interface IAuthorDao  extends JpaRepository<Author, Integer>{

}
