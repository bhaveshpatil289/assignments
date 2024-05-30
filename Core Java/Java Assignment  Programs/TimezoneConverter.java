package com.wipro.Assignments;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimezoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the date and time (YYYY-MM-DD HH:MM): ");
        String inputDateTime = scanner.nextLine();

        System.out.print("Enter the source timezone: ");
        String sourceTimezone = scanner.nextLine();

        System.out.print("Enter the target timezone: ");
        String targetTimezone = scanner.nextLine();

        LocalDateTime localDateTime = LocalDateTime.parse(inputDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(sourceTimezone));

        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimezone));

        String outputDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(targetZonedDateTime);

        System.out.println("Converted time in " + targetTimezone + ": " + outputDateTime);

        scanner.close();
    }
}




