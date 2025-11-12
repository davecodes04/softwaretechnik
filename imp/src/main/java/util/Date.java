package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {

    public int calculateDaysBetween(String dateRangeString) {
        Pattern pattern = Pattern.compile("(\\d{2}\\.\\d{2}) - (\\d{2}\\.\\d{2})");
        Matcher matcher = pattern.matcher(dateRangeString);

        if (matcher.find()) {
            try {
                String startDateStr = matcher.group(1);
                String endDateStr = matcher.group(2);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                int currentYear = LocalDate.now().getYear();

                LocalDate startDate = LocalDate.parse(startDateStr + "." + currentYear, formatter);
                LocalDate endDate = LocalDate.parse(endDateStr + "." + currentYear, formatter);

                long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

                return (int) daysBetween;

            } catch (Exception e) {
                System.err.println("Error parsing dates: " + e.getMessage());
                return -1;
            }
        } else {
            // String did not match the expected format
            System.err.println("Invalid date range format. Expected 'dd.MM - dd.MM'");
            return -1;
        }
    }

}
