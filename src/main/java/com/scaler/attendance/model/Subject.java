package com.scaler.attendance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Subjects")
public class Subject{
    // 1 ICP 2 CLI 3 Maths 4 English
    @Id
    Integer id;
    @Column
    String name;
}
