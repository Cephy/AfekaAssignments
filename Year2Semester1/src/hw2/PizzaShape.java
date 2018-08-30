package hw2;


import java.awt.Color;
import java.awt.Graphics;

public class PizzaShape extends Shape {

	private int width;
	private int xTopLeft;
	private int yTopLeft;
	private final int JUMP_ANGLE = 40;						// jump angle from slice to slice
	private final int FULL_CIRCLE = 360;					// Full Circle stop size
	private final int FULL_SLICE_SIZE = 45;   				// Full Slice size with space 
	private final int CIRCLE_STARTIG_POINT = 5;
	
	public PizzaShape(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		for (int i = CIRCLE_STARTIG_POINT; i < FULL_CIRCLE; i += FULL_SLICE_SIZE) {
			g.fillArc(xTopLeft, yTopLeft, width, width, i, JUMP_ANGLE);
		}
	}

	@Override
	public int getCenterY() {
		return yTopLeft + (width / 2);
	}

	@Override
	public int getCenterX() {
		return xTopLeft + (width / 2);
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setXTopLeft(int xTopLeft) {
		this.xTopLeft = xTopLeft;
	}

	public int getXTopLeft() {
		return xTopLeft;
	}

	public void setYTopLeft(int yTopLeft) {
		this.yTopLeft = yTopLeft;
	}

	public int getYTopLeft() {
		return yTopLeft;
	}

}
