import java.awt.*;
import tools.*;

public class Stone extends Pattern{

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

    public void rotate() {
        Pattern newpattern = new Pattern();
        newpattern.setWidth(getWidth());
        // Implement rotate here
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