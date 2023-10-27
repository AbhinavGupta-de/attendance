package com.scaler.attendance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "User")


public class User{
    @Id
    @GeneratedValue
    Integer id;
    @Column
    String name;
    @Column
    String email;
    @Column
    String password;
    @Column
    String role;
}

