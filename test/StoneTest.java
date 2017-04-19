import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoneTest {
    @Test
    void testT() {
        String stone = new Stone(StoneTypes.T).getPatternString();
        String shouldBe =
                "_x__\n" +
                        "xxx_\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testL() {
        String stone = new Stone(StoneTypes.L).getPatternString();
        String shouldBe =
                "xxx_\n" +
                        "x___\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testJ() {
        String stone = new Stone(StoneTypes.J).getPatternString();
        String shouldBe =
                "xxx_\n" +
                        "__x_\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testS() {
        String stone = new Stone(StoneTypes.S).getPatternString();
        String shouldBe =
                "_xx_\n" +
                        "xx__\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testZ() {
        String stone = new Stone(StoneTypes.Z).getPatternString();
        String shouldBe =
                "xx__\n" +
                        "_xx_\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testSquare() {
        String stone = new Stone(StoneTypes.SQUARE).getPatternString();
        String shouldBe =
                "xx__\n" +
                        "xx__\n" +
                        "____\n" +
                        "____\n";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testBar() {
        String stone = new Stone(StoneTypes.BAR).getPatternString();
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
        assertEquals(shouldBe, stone.getPatternString());
    }

    @Test
    void randomStone() {
        Stone stone = new Stone();
        assertTrue(stone.getPatternString().contains("x"));
    }

    @Test
    void emptyStoneType() {
        assertEquals(StoneType.toString(null), "");
    }
}
