import java.awt.*;
import tools.*;

public class Stone extends RotatablePattern{

    StoneTypes type;
    Point position = null;

    public Stone() {
        this(StoneType.random());
    }

    public Stone(StoneTypes type) {
        super(4, 4);
        this.type = type;
        set(StoneType.getPattern(type));
    }

    public Stone(StoneTypes type, Point position) {
        this(type);
        this.position = position;
    }

    // public void rotate() {
    //     boolean[][] newpattern = new boolean[4][4];
    //     for (int x = 0; x < pattern.length; x++) {
    //         for (int y = 0; y < pattern[x].length; y++)
    //             newpattern[x][3 - y] = pattern[y][x];
    //     }
    //     pattern = newpattern;
    // }

    public boolean[] getPattern() {
        return pattern;
    }

    public String getPatternString() {
        return super.toString();
    }

    @Override
    public String toString() {
        return StoneType.toString(type);
    }
}