import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void dateTime() throws Exception {
        String toParse = "2023-03-01T13:00:00Z";
        assertEquals("2023-03-01T13:00Z",  Main.dateTime(toParse).toString());
    }

    @Test
    public void isBlank() {
        String toParse = "";
        Exception dtpe = assertThrows(DateTimeParseException.class, () -> Main.dateTime(toParse).toString());
        assertEquals("this string could not be parsed", dtpe.getMessage());
    }

    @Test
    public void isNull() {
        String toParse = null;
        Exception npe = assertThrows(NullPointerException.class, () -> Main.dateTime(toParse).toString());
        assertEquals("cannot parse a null string!", npe.getMessage());
    }

    @Test
    public void toDate() {
        String toParse = "2023-03-01T13:00:00Z";
        assertEquals("01 marzo 2023", Main.toDate(OffsetDateTime.parse(toParse)));
    }
}
