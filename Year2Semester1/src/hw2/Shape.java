package hw2;


import java.awt.Color;

public abstract class Shape implements IDrawnShape {

	private Color color;

	public Shape(Color color) {
		this.color = color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public abstract int getCenterY();

	public abstract int getCenterX();

	public boolean equal(Shape shape) {
		if (color == shape.getColor() && shape.getClass() == getClass()) { // Checks
																			// if
																			// it's
																			// the
																			// same
																			// type
																			// of
																			// shape
																			// and
																			// color
			return true;
		}
		return false;
	}

}
