package com.scaler.attendance.repository;

import com.scaler.attendance.model.Student;
import com.scaler.attendance.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public StudentRepository(){

    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudent(String studentId){
        for(Student student: students){
            if(student.getStudentID().equals(studentId)){
                return student;
            }
        }
        return null;
    }

    @PostConstruct
    public void init(){
        User user1 = new User("Abhinav Gupta", "abhinav.23bcs10090@ms.sst.scaler.com", "1234567890", "student");
        Student student1 = new Student(user1, "23BCS10090", "2");
        User user2 = new User("Aditya P. Dash", "aditya.23bcs10138@ms.sst.scaler.com", "2343343", "student");
        Student student2 = new Student(user2, "23BCS10138", "2");

        students.add(student1);
        students.add(student2);
    }
}
