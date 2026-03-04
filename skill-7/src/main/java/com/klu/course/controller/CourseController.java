package com.klu.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.course.model.Course;
import com.klu.course.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // CREATE
    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        service.addCourse(course);
        return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);
    }

    // READ ALL
    
    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable int id) {
        return service.getCourseById(id)
                .map(course -> new ResponseEntity<Object>(course, HttpStatus.OK))
                .orElse(new ResponseEntity<Object>("Course not found", HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable int id, @RequestBody Course course) {
        return service.updateCourse(id, course)
                .map(c -> new ResponseEntity<>("Course updated successfully", HttpStatus.OK))
                .orElse(new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND));
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        if (service.deleteCourse(id))
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title) {
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }
}