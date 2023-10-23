package com.scaler.attendance.service;

import com.scaler.attendance.repository.MarkAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkAttendanceService {

    @Autowired
    private MarkAttendanceRepository markAttendanceRepository;

    public boolean markAttendance(String studentId, Integer classId, Integer value) {

        boolean present = value > 4;

        return markAttendanceRepository.markAttendance(studentId, classId, present);
    }

}
