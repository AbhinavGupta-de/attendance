package com.scaler.attendance.service;

import com.scaler.attendance.model.Student;
import com.scaler.attendance.model.User;
import com.scaler.attendance.repository.StudentRepository;
import com.scaler.attendance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    // Methods that we need
    // 1) Get students with a particular ID
    // 2) Add students to the database(future scope)
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final UserRepository userRepository;

    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public Optional<Student> getStudent(String rollNumber) {
        return studentRepository.findByRollNumber(rollNumber);
    }

    public boolean addStudent(Integer userId, String rollNumber, String batch) {
        if(userId == null || rollNumber == null || batch == null){
            return false;
        }
        try{

            Optional<User> user = userRepository.findById(userId);

            if(user.isEmpty()){
                return false;
            }

            Student student = new Student();
            student.setUser(user.get());
            student.setRollNumber(rollNumber);
            student.setBatch(batch);
            studentRepository.save(student);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}


