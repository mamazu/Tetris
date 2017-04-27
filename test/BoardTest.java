import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    public final static String EMPTY_BOARD ="__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n" +
            "__________\n";

    @Test
    void emptyBoard() {
        Board b = new Board();
        String emptyBoard = b.toString();
        assertEquals(EMPTY_BOARD, emptyBoard);
    }

    @Test
    void invalidBoard() {
        Board b = new Board(-1, 0);
        String emptyBoard = b.toString();
        assertEquals(EMPTY_BOARD, emptyBoard);
    }

    @Test
    void smallBoard() {
        Board b = new Board(10, 4);
        String emptyBoard = b.toString();
        String shouldBe = "__________\n" +
                "__________\n" +
                "__________\n" +
                "__________\n";
        assertEquals(shouldBe, emptyBoard);
    }

}
