package com.scaler.attendance.service;

import com.scaler.attendance.model.Student;
import com.scaler.attendance.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    // Methods that we need
    // 1) Get students with a particular ID
    // 2) Add students to the database(future scope)
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudent(String rollNumber) {
        return studentRepository.findByRollNumber(rollNumber);
    }
}
