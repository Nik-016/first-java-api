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
	/*
	//Post request add a person
	/*
	@PostMapping("/addPerson1")
	public String addPerson(@RequestBody Person1 person) {
		persons.add(person); //add to the list
		return "Person added Successfully!";
	}
	
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
	*/
	//Day 10
	@PostMapping("/addPerson1")
	public ResponseEntity<String> addPerson(@RequestBody Person1 newPerson){
		persons.add(newPerson);
		return new ResponseEntity<>("Person added successfully!",HttpStatus.CREATED);
	}



	//updated code with rersponseEntity
	
	//Get all Person
	@GetMapping("/getAllPerson")
	public ResponseEntity<List<Person1>> getAllPerson(){
		if(persons.isEmpty()) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
		}
	return new ResponseEntity<>(persons,HttpStatus.OK); //200
}
	//GET : one person by id
	@GetMapping("/getPersonById/{id}")
	public ResponseEntity<Person1> getPersonById(@PathVariable int id){
		for (Person1 p : persons) {
			if (p.getId() == id) {
				return new ResponseEntity<>(p, HttpStatus.OK); //200 + JSON object
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 200 + JSON object
	}
	
	//put:update a person (id in URL MUST match id in body)
	
	public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestBody Person1 updatePerson){
		//Guard : path id and id must match (prevents accidental wrong updates)
		if (updatePerson.getId() != id) {
			return new ResponseEntity<>("Path id and body id must match.", HttpStatus.BAD_REQUEST); //400	
		}
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getId() == id) {
				return new ResponseEntity<>("Person updated Successfully!",HttpStatus.OK); // 200
			}
		}
		return new ResponseEntity<>("Person Not Found.",HttpStatus.NOT_FOUND); //404
	}
	//DELETE: remove a person by id
	@DeleteMapping("/deletePerson/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable int id){
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getId() == id) {
				persons.remove(i);
				return new ResponseEntity<>("Person deleted Successfully!",HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>("Person Not Found",HttpStatus.NOT_FOUND); //404
		
	}
	}