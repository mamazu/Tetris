public class Game{
	Board board = new Board();
	Stone next = new Stone();

	public static void main(String[] args){
		Game g = new Game();
		if(args.length == 2 && args[1].equals("cli")){
			System.out.print(g.board.toString());
			return;
		}
		System.out.println(g.next.toString());
		// Game with GUI
	}
}