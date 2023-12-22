import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void dateTime() {
        String toParse = "2023-03-01T13:00:00Z";
        assertEquals("2023-03-01T13:00Z", Main.dateTime(toParse).toString());
    }

    @Test
    public void isBlank() {
        String toParse = "";
        Exception e = assertThrows(DateTimeParseException.class, () -> Main.dateTime(toParse).toString());
        assertEquals("The string could not be parsed", e.getMessage());
    }

    @Test
    public void isNull() {
        String toParse = null;
        Exception e = assertThrows(NullPointerException.class, () -> Main.dateTime(toParse).toString());
        assertEquals("cannot parse a null string!", e.getMessage());
    }


    @Test
    public void year() {
        String toParse = "2023-03-01T13:00:00Z";
        assertEquals(2023, Main.year(OffsetDateTime.parse(toParse)));
    }

    @Test
    public void month() {
        String toParse = "2023-03-01T13:00:00Z";
        assertEquals(3, Main.month(OffsetDateTime.parse(toParse)));
    }

    @Test
    public void day() {
        String toParse = "2023-03-01T13:00:00Z";
        assertEquals(1, Main.day(OffsetDateTime.parse(toParse)));
    }

    @Test
    public void weekDay() {
        String toParse = "2023-03-01T13:00:00Z";
        assertEquals("WEDNESDAY", Main.weekDay(OffsetDateTime.parse(toParse)));
    }
}