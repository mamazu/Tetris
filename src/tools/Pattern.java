package tools;

import java.awt.*;

public class Pattern {
	public final static int WIDTH = 4;
	public final static int HEIGHT = 4;

	protected boolean[] pattern;
	private int width;

	public Pattern() {
		this(Pattern.WIDTH, Pattern.HEIGHT);
	}

	public Pattern(Pattern copy) {
		width = copy.width;
		pattern = new boolean[copy.pattern.length];
	}

	public Pattern(int x, int y) {
		if (x < 1 || y < 1) {
			x = Pattern.WIDTH;
			y = Pattern.HEIGHT;
		}
		width = x;
		pattern = new boolean[x * y];
	}

	public Dimension getDimension() {
		return new Dimension(width, pattern.length / width);
	}

	protected void set(int x, int y, boolean value) {
		int index = index(x, y);
		if (index < 0 || index >= pattern.length)
			return;
		pattern[index] = value;
	}

	protected void set(Pattern p){
		pattern = p.pattern;
	}

	protected void getWidth() {return width;}

	protected void setWidth(int width) {
		if (width < 1)
			return
			  this.width = width;
	}

	protected boolean get(int x, int y) {
		int index = index(x, y);
		if (index < 0 || index >= pattern.length)
			return false;
		return pattern[index];
	}

	private int index(int x, int y) {
		return y * width + x;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < pattern.length; i++) {
			s.append(pattern[i] ? "x" : "_");
			if ((i + 1) % width == 0)
				s.append("\n");
		}
		return s.toString();
	}

	// ----------------- STATIC METHODS -----------------
	public static Pattern add(Pattern p1, Pattern p2) {
		throw new Exception("Not implemented");
		//return new Pattern();
	}
}