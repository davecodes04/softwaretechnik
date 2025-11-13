package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {

    // Calculates the number of days between two dates
    public int calculateDaysBetween(String dateRangeString) {
        // Regex pattern to match the expected format: "dd.MM - dd.MM"
        Pattern pattern = Pattern.compile("(\\d{2}\\.\\d{2}) - (\\d{2}\\.\\d{2})");
        Matcher matcher = pattern.matcher(dateRangeString);

        // Check if the given string matches the pattern
        if (matcher.find()) {
            try {
                // Extract both date parts (only day and month)
                String startDateStr = matcher.group(1);
                String endDateStr = matcher.group(2);

                // Create a formatter for full dates (day.month.year)
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                // Use the current year as a base for both dates
                int currentYear = LocalDate.now().getYear();

                // Parse both dates with the current year first
                LocalDate startDate = LocalDate.parse(startDateStr + "." + currentYear, formatter);
                LocalDate endDate = LocalDate.parse(endDateStr + "." + currentYear, formatter);

                // Handle year crossover:
                // If the end date is before the start date, it means the vacation crosses into the next year
                if (endDate.isBefore(startDate)) {
                    endDate = endDate.plusYears(1);
                }

                // Calculate the days between the two dates (inclusive)
                long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1;

                // Return the number of days as an integer
                return (int) daysBetween;

            } catch (Exception e) {
                // Catch parsing errors and print them for debugging
                System.err.println("Error parsing dates: " + e.getMessage());
                return -1;
            }
        } else {
            // Print an error message if the input does not match "dd.MM - dd.MM"
            System.err.println("Invalid date range format. Expected 'dd.MM - dd.MM'");
            return -1;
        }
    }

    // Checks if the correct date format was upheld
    public boolean checkDateFormatting(String date){
        // The expected format is strictly two digits for the day, a dot, and two digits for the month.
        // Example of valid input: "05.11" or "31.12"
        String regex = "^\\d{2}\\.\\d{2}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        // Return true if the date matches the format, false otherwise
        return matcher.matches();
    }

}
