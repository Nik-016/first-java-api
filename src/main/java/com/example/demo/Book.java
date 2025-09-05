package com.example.demo;

public class Book {
	private int id;
	private String title;
	private String author;
	private int year;
	
	Book(int id, String title, String author){
	this.id = id;
	this.author = author;
	this.title = title;
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	}
