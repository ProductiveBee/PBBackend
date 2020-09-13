package com.example.pbbackend.utils;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CountDaysInBetween {
    public long countDays(String strtdate, String enddate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        LocalDate date1 = LocalDate.parse(strtdate, dtf);
        LocalDate date2 = LocalDate.parse(enddate, dtf);
        long daysBetween = Duration.between(date1, date2).toDays();
        System.out.println("Days: " + daysBetween);
        return daysBetween;
    }
}
