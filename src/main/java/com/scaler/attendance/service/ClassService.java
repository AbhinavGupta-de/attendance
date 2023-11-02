package com.scaler.attendance.service;

import com.scaler.attendance.model.Classes;
import com.scaler.attendance.model.Subject;
import com.scaler.attendance.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassService {

    @Autowired
        private final ClassRepository classRepository;
    @Autowired
        private final SubjectService subjectService;

        public ClassService(ClassRepository classRepository, SubjectService subjectService) {
            this.classRepository = classRepository;
            this.subjectService = subjectService;
        }

        public Optional<List<Classes>> getClasses(String date) {
            return classRepository.findByDate(date);
        }

        public Optional<Classes> getClass(Integer id) {
            return classRepository.findById(id);
        }

        public boolean addClass(String date, String subject, String startTime, String endTime, String mode, String location) {


            if(date == null || subject == null || startTime == null || endTime == null || mode == null || location == null){
                return false;
            }

            try{

                if(subjectService.getSubject(subject).isEmpty()){
                    return false;
                }

                Classes classes = new Classes();
                classes.setDate(date);
                classes.setSubject(subjectService.getSubject(subject).get());
                Integer id = subjectService.getSubject(subject).get().getId();
                classes.setStartTime(startTime);
                classes.setEndTime(endTime);
                classes.setMode(mode);
                classes.setLocation(location);
                String idString = date + id.toString();
                classes.setId(Integer.parseInt(idString));
                classRepository.save(classes);

            }
            catch (Exception e){
                return false;
            }
            return true;
        }
}




