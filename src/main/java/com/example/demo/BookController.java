package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	List<Book> books = new ArrayList<>();
	
	@PostMapping("/addBook")
	public ResponseEntity<String> addBook(@RequestBody Book b){
		books.add(b);
		return new ResponseEntity<>("Book Added SuccessFully",HttpStatus.CREATED);
	}
	@GetMapping("/getBook")
	public ResponseEntity<List<Book>> getAllBook() {
		if(books.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/getId/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id){
		for (Book b: books) {
		if (b.getId() == id) {
		return new ResponseEntity<>(b, HttpStatus.OK);
		}
	}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/GetBookByAuthor/{author}")
	public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String author){
		List<Book> result = new ArrayList<>();
		for (Book b : books) {
			if (b.getAuthor() == author) {
				result.add(b);
			}
		}
		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<String> updateBook(@RequestBody Book updateBook,@PathVariable int id){
		if (updateBook.getId() != id) {
			return new ResponseEntity<>("Path id and body id must match.", HttpStatus.BAD_REQUEST);
		}
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == id) {
				books.set(i, updateBook); //replace old person with new person
				return new ResponseEntity<>("Person Update SuccessFully", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Book Not Found",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@RequestBody Book b,@PathVariable int id) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == id) {
				books.set(i, b);
				return new ResponseEntity<>("Book Deleted Successful",HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
	}
}
