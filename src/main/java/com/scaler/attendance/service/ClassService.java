package com.scaler.attendance.service;

import com.scaler.attendance.model.Classes;
import com.scaler.attendance.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassService {


        @Autowired
        private ClassRepository classRepository;

        public Optional<List<Classes>> getClasses(Integer date) {
            return classRepository.getClasses(date);
        }
}
