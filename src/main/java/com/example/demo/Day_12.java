package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day_12 {
	private List<Person1> persons = new ArrayList<>();
	
	@GetMapping("/getPersonByAge/{age}")
			public ResponseEntity<List<Person1>> getPersonByAge(@PathVariable int age){
				List<Person1> result = new ArrayList<>();
					for (Person1 p : persons) {
						if (p.getAge() > age) {
							result.add(p);
						}
					}
					if (result.isEmpty()) {
						return new ResponseEntity<>(HttpStatus.NOT_FOUND); //no matches	
					}
					return new ResponseEntity<>(result,HttpStatus.OK); //return matches
			}
}
