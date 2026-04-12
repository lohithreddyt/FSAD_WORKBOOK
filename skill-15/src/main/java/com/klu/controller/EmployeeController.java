package com.klu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @PostMapping("/admin/add")
    public String addEmployee() {
        return "Employee Added Successfully";
    }

    @DeleteMapping("/admin/delete")
    public String deleteEmployee() {
        return "Employee Deleted Successfully";
    }

    @GetMapping("/employee/profile")
    public String profile() {
        return "Employee Profile Data";
    }
}