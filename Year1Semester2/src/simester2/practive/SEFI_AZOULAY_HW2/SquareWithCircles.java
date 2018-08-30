package simester2.practive.SEFI_AZOULAY_HW2;

import java.awt.Color;
import java.awt.Graphics;

public class SquareWithCircles extends Shape {

	private int width;
	private int xTopLeft;
	private int yTopLeft;

	public SquareWithCircles(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(xTopLeft, yTopLeft, width, width);
		g.fillOval((int) (xTopLeft - width * 0.25), (int) (yTopLeft + width * 0.25), (int) (width * 0.5),
				(int) (width * 0.5)); // Draw left circle
		g.fillOval((int) (xTopLeft + width * 0.75), (int) (yTopLeft + width * 0.25), (int) (width * 0.5),
				(int) (width * 0.5)); // Draw right circle
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
