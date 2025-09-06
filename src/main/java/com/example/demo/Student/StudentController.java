package com.example.demo.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	private List<Student> students = new ArrayList<>();
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student s) {
		students.add(s);
		return new ResponseEntity<>("Student Added Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/getStudent")
	public ResponseEntity<List<Student>> getStudent(){
		if(students.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<List<Student>> getStudentById(@PathVariable int id) {
		for (Student s : students) {
			if(s.getId() == id) {
				return new ResponseEntity<>(HttpStatus.OK) ;
			}
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		@GetMapping("/getStudentByGrade/{grade}")
	public ResponseEntity<List<Student>> getStudentByGrade(@PathVariable String grade){
			List<Student> result = new ArrayList<>();
		for (Student s : students) {
			if (s.getGrade() == grade) {
				result.add(s);
				
			}
		}
		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
		}
	}

