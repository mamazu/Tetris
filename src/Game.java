public class Game{
	Board board = new Board();

	public static void main(String[] args){
		Game g = new Game();
		if(args.length == 2 && args[1].equals("cli")){
			System.out.print(g.board.toString());
			return;
		}
		// Game with GUI
	}
}