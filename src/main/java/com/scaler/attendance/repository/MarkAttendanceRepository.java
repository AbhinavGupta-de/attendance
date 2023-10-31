package com.scaler.attendance.repository;

import com.scaler.attendance.model.Attendance;
import com.scaler.attendance.model.Classes;
import com.scaler.attendance.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


public interface MarkAttendanceRepository extends JpaRepository<Attendance, Integer> {



}
