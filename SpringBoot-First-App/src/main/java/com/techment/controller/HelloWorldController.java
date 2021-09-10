package com.techment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//GET Http Method ------> 
	//http://localhost:portno/hello-world
	
	@GetMapping("/hello-world")
	public String helloWorld()
	{
		return "Hello this is my first demo";
	}

}