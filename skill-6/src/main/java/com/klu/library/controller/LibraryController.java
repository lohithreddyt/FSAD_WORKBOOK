package com.klu.library.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.library.model.Book;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    // 1. Welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System!";
    }

    // 2. Count
    @GetMapping("/count")
    public int getCount() {
        return 100;
    }

    // 3. Price
    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }

    // 4. List of titles
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java Basics", "Spring Boot Guide", "Data Structures");
    }

    // 5. Book by ID
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book with ID: " + id;
    }

    // 6. Search by title
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book with title: " + title;
    }

    // 7. Author name
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    // 8. Add Book (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 9. View All Books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}