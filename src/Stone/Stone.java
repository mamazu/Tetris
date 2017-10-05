package Stone;

import tools.Pattern;

import java.awt.*;

public class Stone extends Pattern {

    private StoneTypes type;
    private Point position = null;

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
        for (int x = 0; x < dim.getWidth(); x++){
            for (int y = 0; y < height; y++){
                newpattern.set((height - 1) - y, x, pattern[index(x, y)]);
            }
        }
        set(newpattern);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point point){
        if(point.x < 0 || point.y < 0){
            return;
        }
        position=point;
    }

    public void constrain(Dimension constrains){
        position.x = Math.min(Math.max(0, position.x), constrains.width);
        position.y = Math.min(Math.max(0, position.y), constrains.height-getHeight());
    }

    public String getPatternString() {
        return super.toString();
    }

    @Override
    public String toString() {
        return StoneType.toString(type);
    }

    public void moveDown() {
        position.y++;
    }

    public void moveRight() {
        position.x++;
    }

    public void moveLeft() {
        position.x--;
    }
}