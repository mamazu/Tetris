public class Game {

    Board board = new Board();
    Stone next = new Stone();
    private int score = 0;

    public static void main(String[] args) {
        Game g = new Game();
        if (args.length == 1 && args[0].equals("cli")) {
            System.out.println("The current state of the board");
            System.out.println(g.board.withStone());
            System.out.println("Next stone is: " + g.getNextStone());
            System.out.println("Next pattern is: \n" + g.getNextStone().getPatternString());
            g.update();
            System.out.println("Board after update");
            System.out.println(g.board.withStone());
            System.out.println("Next stone is: " + g.getNextStone());
            System.out.println("Next pattern is: \n" + g.getNextStone().getPatternString());
            return;
        }
        // Game with GUI
    }

    public Board getBoard() {
        return board;
    }

    public void control(int direction) {
        if (direction == -1)
            board.rotateNext();
        else
            board.control(direction);
    }

    Stone getNextStone(){
        return getBoard().getNext();
    }

    public void update() {
        if (board.hasCollided()) {
            int rows = board.removeRows();
            score += rows * 100;
            board.next();
        }
        board.update();
    }
}
