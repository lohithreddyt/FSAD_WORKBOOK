package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {

        Student student = repository.findById(id).orElse(null);

        if (student == null) {
            throw new RuntimeException("Student not found with ID: " + id);
        }

        return student;
    }

    public Student updateStudent(Long id, Student student) {

        Student existing =
                repository.findById(id).orElse(null);

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());

        return repository.save(existing);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}