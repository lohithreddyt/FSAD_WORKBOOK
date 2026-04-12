package com.klu.controller;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Student;
import com.klu.service.StudentService;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Tag(
	    name = "Student API",
	    description = "CRUD operations for Student"
	)
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;
    

    @Operation(summary = "Add new student")

    @ApiResponse(
        responseCode = "200",
        description = "Student added successfully"
    )
    @PostMapping
    public Student addStudent(
            @RequestBody Student student) {

        return service.saveStudent(student);
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getAllStudents() {

        return service.getAllStudents();
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable Long id) {

        try {
            return service.getStudentById(id);

        } catch (RuntimeException e) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Student not found with ID: " + id
            );
        }
    }
    

    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return service.updateStudent(id, student);
    }
    
    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id) {

        service.deleteStudent(id);

        return "Student deleted successfully";
    }
}