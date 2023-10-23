package com.scaler.attendance.repository;

import com.scaler.attendance.model.Classes;
import com.scaler.attendance.model.Subject;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ClassRepository {

        private List<Classes> classes = new ArrayList<>();

        public ClassRepository() {

        }


        public Optional<List<Classes>> getClasses(Integer date) {
                return Optional.of(classes.stream().filter(classes1 -> classes1.getID().equals(date)).toList());
        }



        @PostConstruct
        private void init() {
                Subject sub = new Subject(1, "DSA");
                Subject sub1 = new Subject(2, "System Design");
                Subject sub2 = new Subject(3, "Low Level Design");
                Classes classes1 = new Classes(
                        2023102301,
                        "2023-10-23",
                        sub,
                        "10:00",
                        "11:00",
                        "Online",
                        "Scaler Dashboard"
                );
                Classes classes2 = new Classes(
                        2023102302,
                        "2023-10-23",
                        sub1,
                        "11:00",
                        "12:00",
                        "Offline",
                        "Macro Campus"
                );
                Classes classes3 = new Classes(
                        2023102303,
                        "2023-10-23",
                        sub2,
                        "12:00",
                        "13:00",
                        "Offline",
                        "Micro Campus Reading Room"
                );

                classes.add(classes1);
                classes.add(classes2);
                classes.add(classes3);
        }
}
