public class Game{
	Board board = new Board();
	Stone next = new Stone();

	public static void main(String[] args){
		Game g = new Game();
		if(args.length == 1 && args[0].equals("cli")){
			System.out.print(g.board.toString());
			System.out.println("Next stone is: " + g.next.toString());
			return;
		}
		// Game with GUI
	}
}