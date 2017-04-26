import java.awt.*;
import java.util.Arrays;
import tools.Pattern;

class Board extends Pattern{
    public static final int HEIGHT = 20;
    public static final int WIDTH = 10;

    private Stone next;
    private Point movement = new Point(0, 1);

    public Board() {
        this(Board.WIDTH, Board.HEIGHT);
    }

    public Board(int width, int height) {
        super(width, height);
        if(width * height < 1){
            pattern = new boolean[Board.HEIGHT * Board.WIDTH];
            setWidth(Board.WIDTH);
        }
    }

    void update() {
        if (next.position.x == 0 && movement.x == -1 || next.getDimension().getWidth() == getWidth() - 1 && movement.x == 1) {
            movement.x = 0;
        }
    }

    void control(int direction) {
        switch (direction) {
            case 0:
                //up: immediate down
                movement.setLocation(0, pattern.length / getWidth() + 1);
                return;
            case 1:
                //right
                movement.setLocation(1, 1);
                return;
            case 2:
                movement.setLocation(0, 2);
                return;
            case 3:
                movement.setLocation(-1, 1);
                return;
            default:
                System.err.println("Invalid direction");
        }
    }

    private boolean stoneCollides(int dy) {
        System.err.println("Must be implemented");
        // boolean[][] pattern = next.getPattern();
        // for (int y = 0; y < pattern.length; y++) {
        //     for (int x = 0; x < pattern[y].length; x++) {
        //         if (!pattern[y][x]) continue;
        //         int index = index(next.position) + index(x, y + dy);
        //         if (board[index] || (y + dy > board.length / width))
        //             return true;
        //     }
        // }
        return false;
    }

    public Stone getCurrent() {
        return next;
    }

    public void setNext(Stone next) {
        next.position = new Point((getWidth() - next.getWidth()) / 2, 0);
        this.next = next;
    }

    public boolean hasCollided() {
        return next == null;
    }

    void rotateNext() {
        next.rotate();
    }

    public int removeRows() {
        int removed = 0;
        int width = getWidth();
        int max = pattern.length / width;
        for (int i = 0; i < max; i++) {
            // Checks if the row has to be removed
            boolean toRemove = true;
            for (int j = 0; j < width; j++) {
                if (pattern[j + i * width]) continue;
                toRemove = false;
            }
            if (!toRemove) continue;
            removed += 1;
            // Copies the next lines over and fills the rest with false
            for (int otherLines = i; otherLines < max; otherLines++)
                for (int j = 0; j < width; j++) {
                    pattern[j + otherLines * width] = (otherLines + 1) * width < max && pattern[j + (otherLines + 1) * width];
                }
            max -= 1;
        }
        return removed;
    }

    public String withStone(){
        Pattern p = Pattern.add((Pattern) next, (Pattern) this);
        return p.toString();
    }
}
