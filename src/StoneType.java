import java.util.Random;

enum StoneTypes{
	// http://www.russlandjournal.de/unterhaltung/tetris/attachment/tetris-steine/
	BAR, // dark blue
	T, // light blue
	SQUARE, //green
	S, // orange
	Z, // pink
	L, // red
	J // yellow
}

class StoneType {

	static StoneTypes random() {
		final StoneTypes[] values = StoneTypes.values();
		int pick = new Random().nextInt(values.length);
		return values[pick];
	}

	public static boolean[][] getPattern(){
		return getPattern(random());
	}

	public static boolean[][] getPattern(StoneTypes x){
		boolean[][] pattern = new boolean[4][4];
		switch(x){
			case BAR:
				for(int i=0; i<4;i++)
					pattern[i][0] = true;
				break;
			case J:
			case L:
				for(int i=0; i < 3; i++)
					pattern[0][i] = true;
				if(x == StoneTypes.L){
					pattern[1][2] = true;
				}else {
					pattern[1][0] = true;
				}
				break;
			case T:
				for(int i=0; i<=2; i++)
					pattern[1][i] = true;
				pattern[0][2] = true;
				break;
			case SQUARE:
				for(int i=0; i<=1;i++){
					pattern[0][i] = true;
					pattern[1][i] = true;
				}
				break;
			case S:
				for(int i=0; i< 2;i++){
					pattern[0][i+1] = true;
					pattern[1][i] = true;
				}
				break;
			case Z:
				for(int i=0; i< 2;i++){
					pattern[0][i] = true;
					pattern[1][i+1] = true;
				}
				break;
			default:
				System.err.print("Invalid Stone type");
		}
		return pattern;
	}

	public static String toString(StoneTypes type) {
		if(type == null)
			return "";
		return type.toString();
	}
}