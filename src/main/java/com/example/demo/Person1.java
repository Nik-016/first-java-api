package com.example.demo;

public class Person1 {
	private String name;
	private int age;
	
	//constructor
	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//getter method is very important for json to work
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
