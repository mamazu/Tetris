import java.awt.*;

class Board {
    public static final int HEIGHT = 20;
    public static final int WIDTH = 10;

    private final int width;

    private final boolean[] board;
    private Stone next;
    private Point movement = new Point(0, 1);

    public Board() {
        this(WIDTH, HEIGHT);
    }

    public Board(int width, int height) {
        if (width > 0 && height > 0) {
            board = new boolean[height * width];
            this.width = width;
        } else {
            board = new boolean[HEIGHT * WIDTH];
            this.width = WIDTH;
        }
    }

    void update() {
        if(next.position.x == 0 && movement.x == -1 || next.dimension().x == width -1 && movement.x == 1){
            movement.x = 0;
        }
    }

    void control(int direction) {
        switch (direction) {
            case 0:
                //up: immediate down
                movement.setLocation(0, board.length / width + 1);
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
        boolean[][] pattern = next.getPattern();
        for (int y = 0; y < pattern.length; y++) {
            for (int x = 0; x < pattern[y].length; x++) {
                if (!pattern[y][x]) continue;
                int index = index(next.position) + index(x, y + dy);
                if (board[index] || (y + dy > board.length / width))
                    return true;
            }
        }
        return false;
    }

    private int index(Point position) {
        return index(position.x, position.y);
    }

    public boolean getValue(int x, int y) {
        return board[index(x, y)];
    }

    private int index(int x, int y) {
        return y * width + x;
    }

    public Stone getCurrent(){
        return next;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\n+-------------------+");
        for (int i = 0; i < board.length; i++) {
            if (i % width == 0)
                result.append("\n|");
            char filled = board[i] ? 'x' : ' ';
            result.append(filled).append("|");
        }
        result.append("\n+-------------------+\n");
        return result.toString();
    }

    public void setNext(Stone next) {
        this.next = next;
    }

    public boolean hasCollided() {
        return next == null;
    }

    void rotateNext() {
        next.rotate();
    }
}

