package com.scaler.attendance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Subjects")
public class Subject{
    // 1 ICP 2 CLI 3 Maths 4 English
    @Id
    @GeneratedValue
    Integer id;
    @Column
    String name;
}
