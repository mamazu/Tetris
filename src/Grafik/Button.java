//package Grafik;

import java.awt.*;

class Button {
    public static final double HEIGHT = 0.025;
    public static final double WIDTH = 0.25;

    private double x, y;
    private String content;
    private double width, height;
    private Color background = Color.WHITE;

    public Button(String content, double x, double y) {
        setContent(content);
        setPosition(x, y);
    }

    public Button(String content, double x, double y, double width, double height) {
        this(content, x, y);
        setSize(width, height);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSize(double width, double height) {
        this.width = width < 0 ? Button.WIDTH : width;
        this.height = height < 0 ? Button.HEIGHT : height;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean mouse(double x, double y) {
        boolean xBound = x >= this.x && x <= this.x + width;
        boolean yBound = y >= this.y && y <= this.y + height;
        if (xBound && yBound) {
            background = Color.GREEN;
            return true;
        }
        background = Color.WHITE;
        return false;
    }

    public void draw(Draw context) {

    }
}