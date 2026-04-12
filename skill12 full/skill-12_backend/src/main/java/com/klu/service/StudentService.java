package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student s) {
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student updateStudent(Long id, Student s) {
        Student existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(s.getName());
            existing.setEmail(s.getEmail());
            existing.setCourse(s.getCourse());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}