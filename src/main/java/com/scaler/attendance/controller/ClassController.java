package com.scaler.attendance.controller;

import com.scaler.attendance.model.Classes;
import com.scaler.attendance.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// /api/class/2020-01-01

@RestController
@RequestMapping("/api/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    // JSON response
    // Valid our date
    // TODO - 1. Check if date is valid

    @GetMapping("/{date}")
    public Optional<List<Classes>> getClasses(@PathVariable Integer date) {
        return classService.getClasses(date);
    }
}

