package com.scaler.attendance.controller;

import com.scaler.attendance.service.MarkAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mark-attendance")
public class MarkAttendanceController {

    @Autowired
    private final MarkAttendanceService markAttendanceService;

    public MarkAttendanceController(MarkAttendanceService markAttendanceService) {
        this.markAttendanceService = markAttendanceService;
    }

    @PostMapping("/{rollNumber}/{classId}/{value}")
    public String markAttendance(@PathVariable String rollNumber, @PathVariable Integer classId, @PathVariable Integer value) {
        if(markAttendanceService.markAttendance(rollNumber, classId, value)) {
            return "Attendance marked successfully";
        }
        else {
            return "Attendance could not be marked";
        }
    }
}
