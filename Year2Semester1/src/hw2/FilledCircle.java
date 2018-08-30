package hw2;


import java.awt.Color;
import java.awt.Graphics;

public class FilledCircle extends Shape {

	private int radius;
	private int x;
	private int y;

	public FilledCircle(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(x, y, 2 * radius, 2 * radius);

	}

	@Override
	public int getCenterY() {
		return y + radius;
	}

	@Override
	public int getCenterX() {
		return x + radius;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}
}
