import org.junit.Test;

import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void dateTime() {
        String toParse = "2002-03-01T13:00:00Z";
        assertEquals("2002-03-01T13:00Z", Main.dateTime(toParse).toString());
    }

    @Test
    public void isBlank() {
        String toParse = " ";
        Exception exception = assertThrows(DateTimeParseException.class, () -> Main.dateTime(toParse).toString());
        assertEquals("the string could not be parsed", exception.getMessage());
    }

    @Test
    public void isNull() {
        String toParse = null;
        Exception e = assertThrows(NullPointerException.class, () -> Main.dateTime(toParse).toString());
        assertEquals("cannot parse a null string!", e.getMessage());
    }

    @Test
    public void full() {
        String toParse = "2002-03-01T13:00:00Z";
        assertEquals("Friday, March 1, 2002", Main.full(toParse).toString());
    }

    @Test
    public void medium() {
        String toParse = "2002-03-01T13:00:00Z";
        assertEquals("Mar 1, 2002", Main.medium(toParse).toString());
    }

    @Test
    public void notLong() {
        String toParse = "2002-03-01T13:00:00Z";
        assertEquals("3/1/02", Main.notLong(toParse).toString());
    }
}