package com.scaler.attendance.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassData {
    @JsonProperty("subject")
    private String subject;

    @JsonProperty("date")
    private String date;

    @JsonProperty("endTime")
    private String endTime;

    @JsonProperty("startTime")
    private String startTime;

    @JsonProperty("location")
    private String location;

    @JsonProperty("mode")
    private String mode;

}

