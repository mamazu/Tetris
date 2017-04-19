import java.awt.*;

public class Stone {

    StoneTypes type;
    private boolean[][] pattern;
    private Point position = null;

    public Stone() {
        this(StoneType.random());
    }

    public Stone(StoneTypes type) {
        this.type = type;
        pattern = StoneType.getPattern(type);
    }

    public Stone(StoneTypes type, Point position) {
        this.type = type;
        pattern = StoneType.getPattern(type);
        this.position = position;
    }

    public void rotate() {
        boolean[][] newpattern = new boolean[4][4];
        for (int x = 0; x < pattern.length; x++) {
            for (int y = 0; y < pattern[x].length; y++)
                newpattern[x][3 - y] = pattern[y][x];
        }
        pattern = newpattern;
    }

    public String getPattern() {
        StringBuilder s = new StringBuilder();
        for (boolean[] row : pattern) {
            for (boolean field : row)
                s.append(field ? "x" : "_");
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return StoneType.toString(type);
    }
}