public class Game {

    Board board = new Board();
    Stone next = new Stone();
    private int score = 0;

    public static void main(String[] args) {
        Game g = new Game();
        if (args.length == 1 && args[0].equals("cli")) {
            System.out.print(g.board);
            System.out.println("Next stone is: " + g.getNext());
            System.out.println("Next pattern is: \n" + g.getNext().getPatternString());
            return;
        }
        // Game with GUI
    }

    private Stone next() {
        Stone next = this.next;
        this.next = new Stone();
        return next;
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

    public Stone getNext() {
        return next;
    }

    public void update() {
        board.update();
        if (board.hasCollided()) {
            int rows = board.removeRows();
            score += rows * 100;
            board.setNext(next());
        }
    }
}
