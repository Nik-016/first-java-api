package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@Validated
public class Day13Controller {
	private List<Person1> persons = new ArrayList<>();
	
	@PostMapping("/addPerson2")
	public ResponseEntity<String> addPerson(@Valid @RequestBody Person1 person){
		persons.add(person);
		return new ResponseEntity<>("Persons Added Successfully",HttpStatus.CREATED);
	}
}
