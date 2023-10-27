package com.scaler.attendance.repository;

import com.scaler.attendance.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


public interface StudentRepository extends JpaRepository<Student, String> {

        Optional<Student> findByRollNumber(String rollNumber);
}
