package com.example.student.service;

import com.example.student.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    // ✅ Use addStudent instead of saveStudent
    Student addStudent(Student student);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    Student getStudentById(Long id);
}