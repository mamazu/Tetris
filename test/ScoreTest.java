import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Score.Score;
import java.util.Date;
import java.util.GregorianCalendar;

public class ScoreTest {
    @Test
    void testScoreCreation() {
        Score s = new Score("mamazu", 20);
        assertEquals(s.getUsername(), "mamazu");
        assertEquals(s.getScore(), 20);
        assertTrue(s.getDate().compareTo(new Date()) < 0);
    }

    @Test
    void testScoreDate() {
        Score s = new Score("mamazu", 20, "2017-03-11 18-11-01");
        Date date = new GregorianCalendar(2017,2,11,18,11,1).getTime();
        assertEquals(date, s.getDate());
    }
}
