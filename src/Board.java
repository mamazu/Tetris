import Stone.Stone;
import tools.Movement;
import tools.Pattern;
import java.awt.*;


class Board {
    public static final int HEIGHT = 20;
    public static final int WIDTH = 10;

    private Stone nextStone;
    private Pattern board;
    private Movement movement = Movement.MOVE_NOT;

    Board() {
        board = new Pattern(Board.WIDTH, Board.HEIGHT);
    }

    Board(int width, int height) {
        board = new Pattern(width, height);
    }

    void control(int direction) {
        switch (direction) {
            case 0:
                movement = Movement.MOVE_ALL_THE_WAY_DOWN;
                return;
            case 1:
                movement = Movement.MOVE_RIGHT;
                return;
            case 2:
                movement = Movement.MOVE_DOWN;
                return;
            case 3:
                movement = Movement.MOVE_LEFT;
                return;
            default:
                movement = Movement.MOVE_NOT;
                System.err.println("Invalid direction");
        }
    }

    private void doMove() {
        doMove(this.movement);
    }

    private void doMove(Movement movement) {
        switch (movement) {
            case MOVE_LEFT:
                if (!stoneCollides(new Point(-1, 0)))
                    nextStone.moveLeft();
                break;
            case MOVE_RIGHT:
                if (!stoneCollides(new Point(1, 0)))
                    nextStone.moveRight();
                break;
            case MOVE_DOWN:
                if (!stoneCollides(new Point(0, 1))) {
                    nextStone.moveDown();
                }
                break;
            case MOVE_ALL_THE_WAY_DOWN:
                moveStoneToTheBottom();
                break;
            case MOVE_NOT:
                break;
        }
    }

    private void moveStoneToTheBottom() {
        while (!stoneCollides(new Point(0, 1))) {
            nextStone.moveDown();
        }
    }

    private boolean stoneCollides(Point movement) {
        Pattern nextStonePosition = Pattern.addPadding(nextStone.getWithOffset(), movement);
        return Pattern.and(nextStonePosition, board);
    }

    Dimension getDimension() {
        return board.getDimension();
    }

    Stone getNextStone() {
        if (nextStone == null) {
            Stone next = new Stone();
            next.setPosition(new Point((board.getWidth() - next.getWidth()) / 2, 0));
            this.nextStone = next;
        }
        return nextStone;
    }

    boolean hasCollided() {
        if (stoneCollides(new Point(0, 0))) {
            nextStone = null;
            System.out.println("New the stone has collided");
        }
        return nextStone == null;
    }

    void rotateNextStone() {
        nextStone.rotate();
    }

    int removeRows() {
        return 0;
    }

    void update() {
        doMove();
        doMove(Movement.MOVE_DOWN);

        nextStone.constrain(new Dimension(Board.WIDTH, Board.HEIGHT));
    }

    Pattern withStone() {
        if (nextStone == null) {
            getNextStone();
        }
        Pattern withOffset = Pattern.addPadding(nextStone, nextStone.getPosition());
        return Pattern.add(withOffset, board);
    }
}
