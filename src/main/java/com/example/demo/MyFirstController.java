package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
public class MyFirstController {
	//day 6
	private List<Person1> persons = new ArrayList<>();
	
	//Post request add a person
	/*
	@PostMapping("/addPerson1")
	public String addPerson(@RequestBody Person1 person) {
		persons.add(person); //add to the list
		return "Person added Successfully!";
	}
	*/
	//Get request: fetch all persons
	@GetMapping("/getPerson")
	public List<Person1> getPersons(){
		return persons;
	}
	// Day 7
	//Get person by id (Get with pathVariable
	@GetMapping("/person/{id}")
	public Person1 getPersonById(@PathVariable int id) {
		for(Person1 p : persons) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null; //if not found
	}
	
	//day 8
	@PutMapping("/updatePerson/{id}")
	public String updatePerson(@PathVariable int id,@RequestBody Person1 updatePerson) {
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getId() == id) {
				persons.set(i, updatePerson); //replace old person with new person
				return "Person updated Successfully!";
			}
		}
		return "Person not found";
	}
	
	//day 9
	@DeleteMapping("/deletePerson/{id}")
	public String deletePerson(@PathVariable int id) {
		for (int i = 0; i< persons.size(); i++) {
			if (persons.get(i).getId() == id) {
				persons.remove(i); //remove person from list
				return "Person deleted Successfully!";
			}
		}
		return "Person not found.";
	}
	
	@PostMapping("/addPerson1")
	public ResponseEntity<String> addPerson(@RequestBody Person1 newPerson){
		persons.add(newPerson);
		return new ResponseEntity<>("Person added successfully!",HttpStatus.CREATED);
	}
}


