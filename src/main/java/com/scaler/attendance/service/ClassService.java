package com.scaler.attendance.service;

import com.scaler.attendance.model.Classes;
import com.scaler.attendance.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassService {


    // Methods that we need
    // 1) Get all classes for a particular date
    // 2) Get a particular class




    @Autowired
        private final ClassRepository classRepository;

        public ClassService(ClassRepository classRepository) {
            this.classRepository = classRepository;
        }

        public Optional<List<Classes>> getClasses(String date) {
            return classRepository.findByDate(date);
        }

        public Optional<Classes> getClass(Integer id) {
            return classRepository.findById(id);
        }
}
