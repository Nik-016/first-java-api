package com.example.demo;

public class Person1 {
	private int id;
	private String name;
	private int age;
	
	
	//constructor
	public Person1(int id,String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	//getter method is very important for json to work
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
