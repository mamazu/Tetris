package tools

public class RotatablePattern extends Pattern{
	public RotatablePattern(Pattern copy) {
		super(copy);
	}

	public RotatablePattern(int x, int y) {
		super(x, y);
	}


	public void rotate() {
		boolean[] pattern = new boolean[pattern.length];
		for(int i = 0; i < pattern.length; i++){

		}
		this.pattern = pattern;
	}
}