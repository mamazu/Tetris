import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Score.Score;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.GregorianCalendar;

public class ScoreTest {
    @Test
    void testScoreCreation() {
        Score score = new Score("mamazu", 20);
        assertEquals(score.getUsername(), "mamazu");
        assertEquals(score.getScore(), 20);
        assertTrue(score.getDate().compareTo(new Date()) <= 0);
    }

    @Test
    void testScoreDate() {
        Score score = new Score("mamazu", 20, "2017-03-11 18-11-01");
        Date date = new GregorianCalendar(2017,2,11,18,11,1).getTime();
        assertEquals(date, score.getDate());
    }

    @Test
    void testInvalidDate() {
        // Defining a new output stream
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(stream));

        //Testing
        new Score("mamazu", 20, "2017-03-11");
        assertTrue(stream.toString().length() > 0);
    }

    @Test
    void testDateFormat() {
        Score score = new Score("mamazu", 20, "2017-03-11 18-11-01");
        assertEquals("2017-03-11 18-11-01", score.getFormattedDate());
    }

    @Test
    void testToString() {
        Score score = new Score("mamazu", 20, "2017-03-11 18-11-01");
        assertEquals("mamazu:20:2017-03-11 18-11-01", score.toString());
    }

    @Test
    void compare(){
        Score small = new Score("mamazu", 20);
        Score big = new Score("Simon", 200);
        //Putting in sleep time so that the dates are different
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Score bigger = new Score("HanFeizi", 200);
        assertEquals(small.compareTo(big), -1);
        assertEquals(big.compareTo(bigger), -1);
        assertEquals(bigger.compareTo(small), 1);
    }
}

