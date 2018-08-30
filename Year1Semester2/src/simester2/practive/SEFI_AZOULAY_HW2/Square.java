package simester2.practive.SEFI_AZOULAY_HW2;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

	private int width;
	private int xTopLeft;
	private int yTopLeft;

	public Square(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(xTopLeft, yTopLeft, width, width);
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

	public void setTopLeftX(int xTopLeft) {
		this.xTopLeft = xTopLeft;
	}

	public int getXTopLeft() {
		return xTopLeft;
	}

	public void setTopLeftY(int yTopLeft) {
		this.yTopLeft = yTopLeft;
	}

	public int getYTopLeft() {
		return yTopLeft;
	}
}
