package com.wipro.Assignments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysBetweenDatesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first date (YYYY-MM-DD): ");
        String date1Str = scanner.nextLine();

        System.out.print("Enter the second date (YYYY-MM-DD): ");
        String date2Str = scanner.nextLine();

        LocalDate date1 = LocalDate.parse(date1Str, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate date2 = LocalDate.parse(date2Str, DateTimeFormatter.ISO_LOCAL_DATE);

        long daysBetween = ChronoUnit.DAYS.between(date1, date2);

        System.out.println("Number of days between the two dates: " + daysBetween);

        scanner.close();
    }
}




