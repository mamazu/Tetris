import org.junit.jupiter.api.Test;
import tools.StoneType;
import tools.StoneTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StoneTest {
    @Test
    void testT() {
        String stone = new Stone(StoneTypes.T).getPatternString();
        String shouldBe ="_x_\n" +
                        "xxx";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testL() {
        String stone = new Stone(StoneTypes.L).getPatternString();
        String shouldBe = "x_\n" +
                "x_\n" +
                "xx";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testJ() {
        String stone = new Stone(StoneTypes.J).getPatternString();
        String shouldBe = "xx\n" +
                "x_\n" +
                "x_";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testS() {
        String stone = new Stone(StoneTypes.S).getPatternString();
        String shouldBe = "_xx\n" +
                          "xx_";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testZ() {
        String stone = new Stone(StoneTypes.Z).getPatternString();
        String shouldBe =
                "xx_\n" +
                        "_xx";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testSquare() {
        String stone = new Stone(StoneTypes.SQUARE).getPatternString();
        String shouldBe =
                "xx\n" +
                        "xx";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testBar() {
        String stone = new Stone(StoneTypes.BAR).getPatternString();
        String shouldBe =
                "x\n" +
                        "x\n" +
                        "x\n" +
                        "x";
        assertEquals(shouldBe, stone);
    }

    @Test
    void testNameT() {
        Stone stone = new Stone(StoneTypes.T);
        assertEquals(stone.toString(), "T");
    }

    @Test
    void rotationBAR() {
        Stone stone = new Stone(StoneTypes.BAR);
        stone.rotate();
        assertEquals("xxxx", stone.getPatternString());
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
