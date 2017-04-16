public class Stone{

	private final boolean[][] pattern;
	StoneTypes type;

	public Stone(){
		type = StoneType.random();
		pattern = StoneType.getPattern(type);
	}

	public Stone(StoneTypes type){
		this.type = type;
		pattern = StoneType.getPattern(type);
	}

	@Override
	public String toString() {
		return StoneType.toString(type);
	}
}