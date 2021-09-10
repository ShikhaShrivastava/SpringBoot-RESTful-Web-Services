package com.techment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/helloController")
public class HelloController {
	
	@GetMapping(value="/hello")
	public String getMessage(@RequestHeader	String token)
	{
		return "Hello Spring";
	}

}
