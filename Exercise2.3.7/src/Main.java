import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        String toParse = "2002-03-01T13:00:00Z";
//        OffsetDateTime dateTime = dateTime(toParse);
        System.out.println("offset: " + dateTime(toParse));
        System.out.println("format full: " + full(toParse));
        System.out.println("format medium: " + medium(toParse));
        System.out.println("format short: " + notLong(toParse));
    }

    public static OffsetDateTime dateTime (String string) throws DateTimeParseException {
        if (string != null){
            try {
                OffsetDateTime dateTime = OffsetDateTime.parse(string);
                return dateTime;
            } catch (DateTimeParseException e) {
                if (string.isBlank() && string.isEmpty()) {
                    throw new DateTimeParseException("the string could not be parsed", string, e.getErrorIndex());
                } else {
                    throw new DateTimeParseException("the string could not be parsed", string, e.getErrorIndex());
                }
            }
        } else {
            throw new NullPointerException("cannot parse a null string!");
        }
    }

    public static String full(String string){
        return dateTime(string).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
    }

    public static String medium (String dateAndTime) {
        return dateTime(dateAndTime).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }

    public static String notLong (String dateAndTime) {
        return dateTime(dateAndTime).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    }
}