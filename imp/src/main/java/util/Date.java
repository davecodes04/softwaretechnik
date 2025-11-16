package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {

    // Calculates the number of days between two dates (format already guaranteed correct)
    public int calculateDaysBetween(String dateRangeString) {
        // Splits the String at the '-' symbol into two parts
        String[] parts = dateRangeString.split(" - ");

        // Making separate variables for the two dates
        String startDateStr = parts[0];
        String endDateStr = parts[1];

        // Use full date format with year
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        int currentYear = LocalDate.now().getYear();

        // Parse start and end dates using the current year
        LocalDate startDate = LocalDate.parse(startDateStr + "." + currentYear, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr + "." + currentYear, formatter);

        // Handle year crossover (e.g., 28.12 - 03.01)
        if (endDate.isBefore(startDate)) {
            endDate = endDate.plusYears(1);
        }

        // Calculate inclusive day count
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return (int) daysBetween;
    }

    // Checks if the correct date format was upheld
    public boolean checkDateFormatting(String date) {
        // The expected format is strictly two digits for the day, a dot, and two digits for the month.
        // Example of valid input: "05.11" or "31.12"
        String regex = "^\\d{2}\\.\\d{2}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        // If the format passed to the method is incorrect, then an Exception is thrown
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid date format. Expected 'dd.MM'");
        }

        return true;
    }

}
