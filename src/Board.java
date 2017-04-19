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

    private boolean getValue(int x, int y) {
        return board[index(x, y)];
    }

    private void setValue(int x, int y, boolean value) {
        board[index(x, y)] = value;
    }

    private int index(int x, int y) {
        return y * width + x;
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
}

