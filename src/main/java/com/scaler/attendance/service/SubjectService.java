package com.scaler.attendance.service;

import com.scaler.attendance.model.Subject;
import com.scaler.attendance.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SubjectService {
    @Autowired
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Optional<Subject> getSubject(String name) {
        return subjectRepository.findByName(name);
    }

    public boolean addSubject(String name) {
        if(name == null){
            return false;
        }
        try{
            Subject subject = new Subject();
            subject.setName(name);
            subject.setId(1);
            subjectRepository.save(subject);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
