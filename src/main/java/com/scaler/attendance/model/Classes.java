package com.scaler.attendance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Classes")

public class Classes{
    @Id
    Integer id;
    @Column
    String date;
    @ManyToOne
    Subject subject;
    @Column
    String startTime;
    @Column
    String endTime;
    @Column
    String mode;
    @Column
    String location;
}
