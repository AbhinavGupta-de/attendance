package com.scaler.attendance.controller;

import com.scaler.attendance.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/addSubject/{name}")

    public String addSubject(@PathVariable String name) {
        if (subjectService.addSubject(name)) {
            String msg1 = "Subject added successfully";
            return msg1;
        } else {
            String msg = "Subject not added";
            return msg;
        }
    }
}
