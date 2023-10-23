package com.scaler.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendanceApplication {


	// When they click on the present button form the UI
	// They will send us the student id and the class id
	// And the value.... true/false(0-7)
	// We will store the data in the database

	// ---later versions---
	// We will also store the time at which the student was present


	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

}
