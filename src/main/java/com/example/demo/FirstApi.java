package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	//Day3
	@GetMapping("/add")
	public String add(@RequestParam int a, @RequestParam int b) {
		int result = a + b;
		return  "The Sum is " + result;
	}
	
	//Day 4
	@GetMapping("/person1")
	public Person1 getPerson1() {
		return new Person1("Nik", 22);
	}
	
	@PostMapping("/addPerson")
	public Person1 addPerson(@RequestBody Person1 person) {
		return person;
	}
}

