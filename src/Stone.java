public class Stone{

	private boolean[][] pattern;
	StoneTypes type;

	public Stone(){
		type = StoneType.random();
		pattern = StoneType.getPattern(type);
	}

	public Stone(StoneTypes type){
		this.type = type;
		pattern = StoneType.getPattern(type);
	}

	public void rotate(){
		boolean[][] newpattern = new boolean[4][4];
		for (int x = 0; x < pattern.length; x++) {
			for(int y = 0; y < pattern[x].length; y++)
				newpattern[3-y][x] = pattern[x][y];
		}
		pattern = newpattern;
	}

	public String getPattern(){
		StringBuilder s = new StringBuilder();
		for (boolean[] row: pattern) {
			for(boolean field : row)
				s.append(field ? "x" : "_");
			s.append("\n");
		}
		return s.toString();
	}

	@Override
	public String toString() {
		return StoneType.toString(type);
	}
}