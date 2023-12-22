import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        String toParse = "2023-03-01T13:00:00Z";
        System.out.println("offset: " + dateTime(toParse));
        OffsetDateTime dateTime = dateTime(toParse);
        System.out.println("data: " + toDate(dateTime));
    }

    public static OffsetDateTime dateTime (String string) throws Exception {
        if (string != null) {
            try {
                OffsetDateTime dateAndTime = OffsetDateTime.parse(string);
                return dateAndTime;
            } catch (DateTimeParseException dtpe) {
                if (string.isBlank()) {
                    throw new DateTimeParseException("this string could not be parsed", string, dtpe.getErrorIndex());
                } else {
                    throw new Exception("there was an error during parsing");
                }
            }
        } else {
            throw new NullPointerException("cannot parse a null string!");
        }
    }

    public static String toDate (OffsetDateTime dateTime) {
        String date = dateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN));
        return date;
    }
}