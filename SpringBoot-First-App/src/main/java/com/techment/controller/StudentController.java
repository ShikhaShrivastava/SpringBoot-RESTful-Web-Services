package com.techment.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techment.entity.Student;

@RestController  // combines @Controller and @ResponseBody----->simplify the creation of RESTful web services
public class StudentController {
	
	//GET Http Method ------> 
		//http://localhost:portno/student
		
		@GetMapping("/student") //shortcut for @RequestMapping(method = RequestMethod. GET) ---->maps HTTP GET req to specific handler methods
		public Student getStudent()
		{
			return new Student("Shikha","Shrivastava");
			
		}
		
		@GetMapping("/students")
		public List<Student> getStudents()
		{
			List<Student> students= new ArrayList<>();
			students.add(new Student("Raina","Verma"));
			students.add(new Student("Anup","Dutta"));
			students.add(new Student("Dhananjay","Sahu"));
			students.add(new Student("Shubham","Sinha"));
			students.add(new Student("Tony","Zen"));
			return students;
			
		}
		
		//  http://localhost:8080/student/1
		//@PathVariable annotation----->method parameter should be map to a URI template variable
		@GetMapping("/student{firstName}/{lastName}")
		public Student studentPathVariable(@PathVariable("firstName") String firstName , @PathVariable("lastName") String lastName)
		{
			return new Student(firstName,lastName);
		}
		
	@GetMapping("/student/query")
	public Student studentQueryParam( @RequestParam(name="firstName") String firstName, @RequestParam(name="lastName") String lastName)
	{
		return new Student(firstName, lastName);
	}
	//NOTE : @RequestParam (Query Paramter)------bind web req parameter with method variable
	
	
	
}
