package com.scaler.attendance.controller;

import com.scaler.attendance.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
            return "Subject added successfully";
        } else {
            return "Subject not added";
        }
    }
}
