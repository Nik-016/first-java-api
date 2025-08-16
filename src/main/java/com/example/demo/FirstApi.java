package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApi {
	@GetMapping("/hello")
	public String hello() {
		return "Hello Recruiters!";	
	}
	//Day 2
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable String name) {
		return "Hello, " + name + " ! Welcome to my API.";
	}
}