package com.scaler.attendance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Student")
public class Student{
    @ManyToOne
    User user;

    // rollNumber -> 23BCS10090
    @Id
    String rollNumber;
    @Column
    String batch;
}
