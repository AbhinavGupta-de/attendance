package com.scaler.attendance.controller;

import com.scaler.attendance.service.MarkAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/mark-attendance")
public class MarkAttendanceController {

    @Autowired
    private MarkAttendanceService markAttendanceService;

    @PostMapping("/{studentId}/{classId}/{value}")
    public String markAttendance(@PathVariable String studentId, @PathVariable Integer classId, @PathVariable Integer value) {
        if(markAttendanceService.markAttendance(studentId, classId, value)) {
            return "Attendance marked successfully";
        }
        else {
            return "Attendance could not be marked";
        }
    }
}
