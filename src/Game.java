public class Game{
	Board board = new Board();

	public static void main(String[] args){
		Game g = new Game();
		System.out.print(g.board.toString());
	}
}