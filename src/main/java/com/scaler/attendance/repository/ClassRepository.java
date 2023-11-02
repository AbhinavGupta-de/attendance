package com.scaler.attendance.repository;

import com.scaler.attendance.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;


public interface ClassRepository extends JpaRepository<Classes, Integer> {
    Optional<List<Classes>> findByDate(String date);
}
