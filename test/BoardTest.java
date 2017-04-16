import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class BoardTest {

    @Test
    void emptyBoard() {
        Board b = new Board();
        String emptyBoard = b.toString();
        String shouldBe = "\n" +
                "+-------------------+\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "+-------------------+\n";
        assertEquals(shouldBe, emptyBoard);
    }

    @Test
    void invalidBoard() {
        Board b = new Board(-1, 0);
        String emptyBoard = b.toString();
        String shouldBe = "\n" +
                "+-------------------+\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "+-------------------+\n";
        assertEquals(shouldBe, emptyBoard);
    }

    @Test
    void smallBoard() {
        Board b = new Board(10, 4);
        String emptyBoard = b.toString();
        String shouldBe = "\n" +
                "+-------------------+\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "| | | | | | | | | | |\n" +
                "+-------------------+\n";
        assertEquals(shouldBe, emptyBoard);
    }

    @Test
    void gettingAnEmptyField() {
        Board b = new Board(10, 4);
        b.setValue(2, 3, true);
        assertEquals(false, b.getValue(3, 2));
    }

    @Test
    void settingASquare() {
        Board b = new Board(10, 4);
        b.setValue(2, 3, true);
        assertEquals(true, b.getValue(2, 3));
    }

    @Test
    void testIndexOutOfBoundsExceptionSet() {
        Board b = new Board(10, 4);
        try {
            b.setValue(9, 8, true);
            fail("Did not throw an error");
        } catch (IndexOutOfBoundsException e) {
            assertEquals(true, true);
        }
    }

    @Test
    void testIndexOutOfBoundsExceptionGet() {
        Board b = new Board(10, 4);
        try {
            b.getValue(9, 8);
            fail("Did not throw an error");
        } catch (IndexOutOfBoundsException e) {
            assertEquals(true, true);
        }
    }
}
