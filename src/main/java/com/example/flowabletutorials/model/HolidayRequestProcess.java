package com.example.flowabletutorials.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HolidayRequestProcess extends Process {
    String employName;
    Integer requestDays;
    String reason;
}
