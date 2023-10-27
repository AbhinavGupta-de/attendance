package com.scaler.attendance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Attendance")
public class Attendance{
        @Id
        @GeneratedValue
        @Column
        Integer id;
        @ManyToOne
        Student student;
        @ManyToOne
        Classes class1;
        @Column
        boolean isPresent;


}


