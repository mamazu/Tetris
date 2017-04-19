public class Game{
	Board board = new Board();
	Stone next = new Stone();

	public static void main(String[] args){
		Game g = new Game();
		if(args.length == 1 && args[0].equals("cli")){
			System.out.print(g.board);
            System.out.println("Next stone is: " + g.getNext());
            System.out.println("Next pattern is: \n" + g.getNext().getPattern());
            return;
        }
        // Game with GUI
	}

    public Stone next() {
        Stone next = this.next;
        this.next = new Stone();
        return next;
    }

    public Stone getNext() {
        return next;
    }
}
