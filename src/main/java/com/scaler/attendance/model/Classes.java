package com.scaler.attendance.model;

public record Classes(
        Integer id,
        String date,
        Subject subject,
        String startTime,
        String endTime,
        String mode,
        String location

) {
    public Integer getID() {
        return id;
    }
}
