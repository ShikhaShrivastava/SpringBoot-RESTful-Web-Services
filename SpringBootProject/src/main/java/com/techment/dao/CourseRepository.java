package com.techment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> { //JPARepo provide api for crud operation

}
