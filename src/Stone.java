public class Stone{

	private final boolean[][] pattern;

	public Stone(){
		 pattern = StoneType.getPattern();
	}

	public Stone(StoneTypes type){
		pattern = StoneType.getPattern(type);
	}
}