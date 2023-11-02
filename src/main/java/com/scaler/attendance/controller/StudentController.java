package com.scaler.attendance.controller;

import com.scaler.attendance.model.Student;
import com.scaler.attendance.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get/{rollNumber}")
    public Optional<Student> getStudent(@PathVariable String rollNumber) {
        return studentService.getStudent(rollNumber);
    }
}
