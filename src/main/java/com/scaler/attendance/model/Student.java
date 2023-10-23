package com.scaler.attendance.model;

public record Student(
        User user,
        // rollNumber -> 23BCS10090
        String rollNumber,
        String batch
) {

    public String getStudentID() {
        return rollNumber;
    }
}
