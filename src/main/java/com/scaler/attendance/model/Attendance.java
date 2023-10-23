package com.scaler.attendance.model;

public record Attendance(
        Student student,
        Classes class1,
        boolean isPresent
) {
}
