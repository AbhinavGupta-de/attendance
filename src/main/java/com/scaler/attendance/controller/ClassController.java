package com.scaler.attendance.controller;

import com.scaler.attendance.helper.ClassData;
import com.scaler.attendance.model.Classes;
import com.scaler.attendance.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// /api/class/2020-01-01

@RestController
@RequestMapping("/api/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/{date}")
    public Optional<List<Classes>> getClasses(@PathVariable String date) {
        return classService.getClasses(date);
    }

    @GetMapping("/class/{id}")
    public Optional<Classes> getClass(@PathVariable Integer id) {
        return classService.getClass(id);
    }

    @PostMapping("/addClass")
    public String addClass(@RequestBody ClassData classData) {

        String date = "";
        String subject = "";
        String startTime = "";
        String endTime = "";
        String mode = "";
        String location = "";


        try {
            date = classData.getDate();
            subject = classData.getSubject();
            startTime = classData.getStartTime();
            endTime = classData.getEndTime();
            mode = classData.getMode();
            location = classData.getLocation();
        }
        catch (Exception e) {
            return "Class not added -- Invalid data";
        }

        if (classService.addClass(date, subject, startTime, endTime, mode, location)) {
            return "Class added successfully";
        } else {
            return "Class not added";
        }
    }
}

