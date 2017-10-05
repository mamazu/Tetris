import tools.Pattern;
import tools.StoneType;
import tools.StoneTypes;

import java.awt.*;

public class Stone extends Pattern {

    StoneTypes type;
    Point position = null;

    public Stone() {
        this(StoneType.random());
    }

    public Stone(StoneTypes type) {
        super(StoneType.getPattern(type));
        this.type = type;
    }

    public Stone(StoneTypes type, Point position) {
        this(type);
        this.position = position;
    }

    public void rotate() {
        Dimension dim = getDimension();
        int height = dim.height;
        Pattern newpattern = new Pattern(height, dim.width);
        for (int x = 0; x < dim.getWidth(); x++)
            for (int y = 0; y < height; y++)
                newpattern.set((height - 1) - y, x, pattern[index(x, y)]);
        set(newpattern);
    }

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