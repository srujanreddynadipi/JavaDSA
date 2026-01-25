package com.prepInsta.java.timedate;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class TimeDate {
    public static <Set> void main(String[] args) {
        LocalDate date  = LocalDate.now();
        System.out.println(date);


        LocalDate date1  = LocalDate.of(2025,12,26);
        System.out.println(date1);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        Period period = Period.ofDays(20);
        System.out.println(period);

        for(String x : ZoneId.getAvailableZoneIds()){
            //System.out.println(x);
        }

        LocalTime time1 = LocalTime.now(ZoneId.of("Europe/Monaco"));
        System.out.println(time1);

        LocalDate localDate1 = LocalDate.of(1989,02,28);
        System.out.println(localDate1);

        LocalDate localDate2 = LocalDate.of(2003 , 8 , 25);
        LocalDate localDate3 = LocalDate.of(2005 , 6 , 30);

        long chronoUnitdays = ChronoUnit.DAYS.between(localDate2,localDate3);
        System.out.println(chronoUnitdays);

        long chronoUnitMonths = ChronoUnit.MONTHS.between(localDate2,localDate3);
        System.out.println(chronoUnitMonths);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDate2.format(dateTimeFormatter));

        Instant instant = Instant.now();
        System.out.println(instant);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

    }




}
