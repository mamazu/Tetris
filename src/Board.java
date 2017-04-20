import java.awt.*;
import java.util.Arrays;

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

    public Dimension getDimension(){
        return new Dimension(width, board.length / width);
    }

    void update() {
        if (next.position.x == 0 && movement.x == -1 || next.dimension().x == width - 1 && movement.x == 1) {
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

    public Stone getCurrent() {
        return next;
    }

    @Override
    public String toString() {
        return display(board);
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

    public int removeRows() {
        int removed = 0;
        int max = board.length / width;
        for (int i = 0; i < max; i++) {
            // Checks if the row has to be removed
            boolean toRemove = true;
            for (int j = 0; j < width; j++) {
                if (board[j + i * width]) continue;
                toRemove = false;
            }
            if (!toRemove) continue;
            removed += 1;
            // Copies the next lines over and fills the rest with false
            for (int otherLines = i; otherLines < max; otherLines++)
                for (int j = 0; j < width; j++) {
                    board[j + otherLines * width] = (otherLines + 1) * width < max && board[j + (otherLines + 1) * width];
                }
            max -= 1;
        }
        return removed;
    }

    public String withStone(){
        boolean[] newBoard = Arrays.copyOf(board, board.length);
        boolean[][] pattern = next.getPattern();
        for(int y = 0; y<pattern.length; y++)
            for(int x = 0; x < pattern[y].length; x++) {
                Point stonePos = new Point(next.position);
                stonePos.translate(x,y);
                newBoard[index(stonePos)] |= pattern[y][x];
            }
        return display(newBoard);
    }

    private String display(boolean[] board) {
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
}
