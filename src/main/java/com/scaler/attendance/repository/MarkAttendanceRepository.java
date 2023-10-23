package com.scaler.attendance.repository;

import com.scaler.attendance.model.Attendance;
import com.scaler.attendance.model.Classes;
import com.scaler.attendance.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MarkAttendanceRepository {

    private List<Attendance> attendance = new ArrayList<>();
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private StudentRepository studentRepository;

    public MarkAttendanceRepository() {

    }

    public boolean markAttendance(String studentId, Integer classId, Boolean value) {
        // We have to check if the classID is valid or not
        // same with the studentID
        try {
            Classes c1 = classRepository.getClass(classId);
            Student student = studentRepository.getStudent(studentId);
            Attendance attendance1 = new Attendance(student, c1, value);
            attendance.add(attendance1);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }



}
