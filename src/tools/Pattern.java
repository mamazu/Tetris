package tools;

import Stone.Stone;

import java.awt.*;
import java.util.Arrays;

public class Pattern {
	public final static int WIDTH = 4;
	public final static int HEIGHT = 4;

	protected boolean[] pattern;
	private int width;

	public Pattern(Pattern copy) {
		set(copy);
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
		pattern = p.pattern.clone();
	}

	public int getWidth() {return width;}

	public void setWidth(int width) {
		if (width < 1)
			return;
		this.width = width;
	}

	private boolean get(int x, int y) {
		int index = index(x, y);
		if (index < 0 || index >= pattern.length)
			throw new IndexOutOfBoundsException();
		return pattern[index];
	}

	public int getHeight(){
	    return pattern.length / width;
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
    public static Pattern addPadding(Pattern p1, Point position){
	    Pattern newPattern = new Pattern(p1.getWidth()+position.x, p1.getHeight() + position.y);
	    for(int x = 0; x < p1.getWidth(); x++){
	        for(int y = 0; y < p1.getHeight(); y++){
	            newPattern.set(x+position.x,y+position.y, p1.get(x, y));
            }
        }

        return newPattern;
    }

	public static Pattern add(Pattern p1, Pattern p2) {
		if(p1.width != p2.width) {
			int size = Math.max(p1.width, p2.width);
			return add(fit(p1, size), fit(p2, size));
		}
		Pattern maxPattern = (p1.pattern.length > p2.pattern.length) ? p1 : p2;
		Pattern minPattern = (maxPattern== p1) ? p2 : p1;
		Pattern p = new Pattern(maxPattern);
		for(int i = 0; i < minPattern.pattern.length; i++){
			p.pattern[i] |= minPattern.pattern[i];
		}
		return p;
	}

	public static Pattern fit(Pattern p, int size){
		if(p.width > size)
			return null;
		if(p.width == size)
			return p;
		// You have to expand
		Pattern newPattern = new Pattern(size, p.getDimension().height);
		for (int x = 0; x < p.width; x++)
			for(int y = 0; y < p.getDimension().height; y++)
				newPattern.set(x,y, p.get(x,y));

		return newPattern;
	}

	public void setAll(boolean all) {
		Arrays.fill(pattern, all);
	}
}