import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoneTest {
    @Test
    void testT() {
        String stone = new Stone(StoneTypes.T).getPattern();
        String shouldBe =
                "_x__\n" +
                        "xxx_\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testL() {
        String stone = new Stone(StoneTypes.L).getPattern();
        String shouldBe =
                "xxx_\n" +
                        "x___\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testJ() {
        String stone = new Stone(StoneTypes.J).getPattern();
        String shouldBe =
                "xxx_\n" +
                        "__x_\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testS() {
        String stone = new Stone(StoneTypes.S).getPattern();
        String shouldBe =
                "_xx_\n" +
                        "xx__\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testZ() {
        String stone = new Stone(StoneTypes.Z).getPattern();
        String shouldBe =
                "xx__\n" +
                        "_xx_\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testSquare() {
        String stone = new Stone(StoneTypes.SQUARE).getPattern();
        String shouldBe =
                "xx__\n" +
                        "xx__\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testBar() {
        String stone = new Stone(StoneTypes.BAR).getPattern();
        String shouldBe =
                "x___\n" +
                        "x___\n" +
                        "x___\n" +
                        "x___\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testNameT() {
        Stone stone = new Stone(StoneTypes.T);
        assertEquals(stone.toString(), "T");
    }

    @Test
    void rotationSquare() {
        Stone stone = new Stone(StoneTypes.SQUARE);
        stone.rotate();
        String shouldBe =
                "__xx\n" +
                        "__xx\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone.getPattern());
    }

    @Test
    void randomStone() {
        Stone stone = new Stone();
        assertTrue(stone.getPattern().contains("x"));
    }

    @Test
    void emptyStoneType() {
        assertEquals(StoneType.toString(null), "");
    }
}
