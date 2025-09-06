package com.example.demo.Student;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Student {
	private int id;
	@NotBlank(message = "Name cannot be empty")
	private String name;
	@Min(value = 0,message = "Age must be >= 0")
	private int age;
	@NotBlank(message = "grade cannot be empty")
	private String grade;
	
	Student(int id,String name,int age,String grade){
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
