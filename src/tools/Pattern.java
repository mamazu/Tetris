package tools;

import java.awt.*;
import java.util.Arrays;

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
		pattern = copy.pattern;
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

	public void set(int x, int y, boolean value) {
		set(index(x,y), value);
	}

	public void set(int index, boolean value) {
		if (index < 0 || index >= pattern.length)
			return;
		pattern[index] = value;
	}

	protected void set(Pattern p){
		width = p.width;
		pattern = p.pattern;
	}

	public int getWidth() {return width;}

	public void setWidth(int width) {
		if (width < 1)
			return;
		this.width = width;
	}

	protected boolean get(int x, int y) {
		int index = index(x, y);
		if (index < 0 || index >= pattern.length)
			return false;
		return pattern[index];
	}

	protected int index(int x, int y) {
		return y * width + x;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < pattern.length; i++) {
			if (i % width == 0 && i != 0)
				s.append("\n");
			s.append(pattern[i] ? "x" : "_");
		}
		return s.toString();
	}

	// ----------------- STATIC METHODS -----------------
	public static Pattern add(Pattern p1, Pattern p2) {
		System.err.println("Not implemented");
		return new Pattern(10, 10);
	}

	public void setAll(boolean all) {
		Arrays.fill(pattern, all);
	}
}