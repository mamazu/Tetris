import Stone.Stone;

import java.util.concurrent.TimeUnit;

public class Game {

    private Board board = new Board();
    private int score = 0;

    public static void main(String[] args) throws InterruptedException {
        Game g = new Game();
//        if (args.length == 1 && args[0].equals("cli")) {
//        }

        while(true){
            System.out.println("Board after update");
            System.out.println(g.board.withStone());
            System.out.println(g.getNextStone().getPosition());

            g.update();
            TimeUnit.SECONDS.sleep(1);

        }
        // Game with GUI
    }

    public Board getBoard() {
        return board;
    }

    public void control(int direction) {
        if (direction == -1) {
            board.rotateNextStone();
        } else {
            board.control(direction);
        }
    }

    public Stone getNextStone() {
        return getBoard().getNextStone();
    }

    public void update() {
        if (board.hasCollided()) {
            int rows = board.removeRows();
            score += rows * 100;
            getNextStone();
        }
        board.update();
    }
}
