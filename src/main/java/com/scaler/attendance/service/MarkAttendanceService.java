package com.scaler.attendance.service;

import com.scaler.attendance.model.Attendance;
import com.scaler.attendance.model.Classes;
import com.scaler.attendance.model.Student;
import com.scaler.attendance.repository.MarkAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarkAttendanceService {

    @Autowired
    private final MarkAttendanceRepository markAttendanceRepository;
    private final ClassService classService;
    private final StudentService studentService;

    public MarkAttendanceService(MarkAttendanceRepository markAttendanceRepository, ClassService classService, StudentService studentService) {
        this.markAttendanceRepository = markAttendanceRepository;
        this.classService = classService;
        this.studentService = studentService;
    }

    public boolean markAttendance(String rollNumber, Integer classId, Integer value) {

        boolean present = value > 4;

        Optional<Classes> c1 = classService.getClass(classId);
        if(c1.isEmpty()) {
            return false;
        }
        Optional<Student> student = studentService.getStudent(rollNumber);
        if(student.isEmpty()) {
            return false;
        }

        // Create an object of Attendance and set the values
        Attendance attendance1 = new Attendance();
        attendance1.setClass1(c1.get());
        attendance1.setStudent(student.get());
        attendance1.setPresent(present);

        // Save the object in the database
        try {
            markAttendanceRepository.save(attendance1);
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

}
