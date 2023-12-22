import java.time.DayOfWeek;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String toParse = "2023-03-01T13:00:00Z";
        System.out.println("date: " + dateTime(toParse));
        OffsetDateTime dateTime = dateTime(toParse);
        System.out.println("year: " + year(dateTime));
        System.out.println("month: " + month(dateTime));
        System.out.println("day: " + day(dateTime));
        System.out.println("day of the week: " + weekDay(dateTime));
    }

    public static OffsetDateTime dateTime(String string) {
        if (string != null) {
            try {
                OffsetDateTime dateTime = OffsetDateTime.parse(string);
                return dateTime;
            } catch (DateTimeParseException e) {
                if (string.isBlank() && string.isEmpty()) {
                    throw new DateTimeParseException("The string could not be parsed", string, e.getErrorIndex());
                } else {
                    throw new DateTimeParseException("The string could not be parsed", string, e.getErrorIndex());
                }
            }
        } else {
            throw new NullPointerException("cannot parse a null string!");
        }
    }

    public static int year(OffsetDateTime dateTime) {
        int yr = dateTime.getYear();
        return yr;
    }

    public static int month(OffsetDateTime date) {
        int mon = date.getMonthValue();
        return mon;
    }

    public static int day(OffsetDateTime date) {
        int dd = date.getDayOfMonth();
        return dd;
    }

    public static String weekDay(OffsetDateTime date) {
        String dayOfWeek = String.valueOf(date.getDayOfWeek());
        return dayOfWeek;
    }

}
