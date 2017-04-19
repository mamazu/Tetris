//package Grafik;

import java.awt.*;

class Knopf {
    public static final double HEIGHT = 0.025;
    public static final double WIDTH = 0.25;

    private double x, y;
    private String content;
    private double width, height;
    private Color background = Color.WHITE;
    private Draw Grafik;
    private Font Schrift;

    public Knopf(String content, double x, double y, Draw d) {
        setContent(content);
        setPosition(x, y);
        this.width = this.WIDTH;
        this.height = this.HEIGHT;
        Grafik = d;
        d.setFont();
    }

    public Knopf(String content, double x, double y, double width, double height, Draw d) {
        this(content, x, y, d);
        if (width < 0 || height < 0) throw new IllegalArgumentException();
        setSize(width, height);
        Grafik = d;
        d.setFont();
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

    public void setSchrift(Font f) {
        Grafik.setFont(f);
    }

    public boolean mouse(double x, double y) {
        boolean xBound = (x >= this.x - width && x <= this.x + width);
        boolean yBound = (y >= this.y - width && y <= this.y + height);
        if (xBound && yBound) {
            background = Color.GREEN;
            return true;
        }
        background = Color.WHITE;
        return false;
    }

    public void zeichneAn() {
        Grafik.setPenColor(Grafik.GREEN);
        Grafik.filledRectangle(this.x, this.y, this.width, this.height);
        Grafik.setPenColor();
        Grafik.rectangle(this.x, this.y, this.width, this.height);
        Grafik.text(this.x, this.y, this.content, 0);
    }

    public void zeichneAus() {
        Grafik.setPenColor(Grafik.WHITE);
        Grafik.filledRectangle(this.x, this.y, this.width, this.height);
        Grafik.setPenColor();
        Grafik.rectangle(this.x, this.y, this.width, this.height);
        Grafik.text(this.x, this.y, this.content, 0);
    }

    public void zeichneAn(String s) {
        Grafik.setPenColor(Grafik.GREEN);
        Grafik.filledRectangle(this.x, this.y, this.width, this.height);
        Grafik.setPenColor();
        Grafik.rectangle(this.x, this.y, this.width, this.height);
        Grafik.text(this.x, this.y, s, 0);
    }
}