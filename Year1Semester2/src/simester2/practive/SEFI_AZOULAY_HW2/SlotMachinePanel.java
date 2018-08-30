package simester2.practive.SEFI_AZOULAY_HW2;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class SlotMachinePanel extends JPanel implements ISlotMachine {

	private final static double SLOT_MACHINE_WIDTH_FRACTION = 0.8;
	private final static int RADIUS_DIVISOR = 6;
	private final static double SLOT_MACHINE_HEIGHT_DIVISOR = 1.4;

	private Square mainMachineCell = new Square(Color.black);
	private Square rightCell = new Square(Color.black);
	private Square leftCell = new Square(Color.black);
	private Square midCell = new Square(Color.black);

	// Three random shapes according to position
	private Shape rightShape;
	private Shape leftShape;
	private Shape midShape;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int panelWidth = getWidth();
		int panelHeight = getHeight();

		// get the shortest length when resized
		int minPanelLength = Math.min(panelWidth, panelHeight);

		double slotMachineWidth = minPanelLength * SLOT_MACHINE_WIDTH_FRACTION;

		int xCenter = panelWidth / 2;
		int yCenter = panelHeight / 2;

		// set the squares for the slot machine skeleton
		setSquares((int) slotMachineWidth, xCenter, yCenter);

		g.setColor(Color.black);

		mainMachineCell.draw(g);
		leftCell.draw(g);
		rightCell.draw(g);
		midCell.draw(g);

		// Draw the Three random shapes
		if (rightShape != null) {
			rightShape.draw(g);
			leftShape.draw(g);
			midShape.draw(g);
		}
	}

	private void setSquares(int slotMachinLength, int xCenter, int yCenter) {

		mainMachineCell.setWidth(slotMachinLength);
		mainMachineCell.setTopLeftX(xCenter - (slotMachinLength / 2));
		int mainBottomY = yCenter - slotMachinLength / 2;
		mainMachineCell.setTopLeftY((int) (mainBottomY / SLOT_MACHINE_HEIGHT_DIVISOR));

		// All cell width and cell Y location are the same
		int cellWidth = slotMachinLength / 5;
		int cellYLocation = mainMachineCell.getYTopLeft() + slotMachinLength / 10;

		/*The X location of each cell is determined by a space 10% of
		slotMachinLength and a size of 30% for each cell*/
		leftCell.setWidth(cellWidth);
		leftCell.setTopLeftX(mainMachineCell.getXTopLeft() + slotMachinLength / 10);
		leftCell.setTopLeftY(cellYLocation);

		rightCell.setWidth(cellWidth);
		rightCell.setTopLeftX(mainMachineCell.getXTopLeft() + (int) (slotMachinLength * 0.4));
		rightCell.setTopLeftY(cellYLocation);

		midCell.setWidth(cellWidth);
		midCell.setTopLeftX(mainMachineCell.getXTopLeft() + (int) (slotMachinLength * 0.7));
		midCell.setTopLeftY(cellYLocation);

	}

	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	public Shape createShape(int index, Square cell) {

		switch (index) {
		case 0:
			FilledCircle fc = new FilledCircle(Color.RED);
			setFilledCircle(fc, cell);
			return fc;

		case 1:
			SquareWithCircles swc = new SquareWithCircles(Color.BLACK);
			setSquareWithCircles(swc, cell);
			return swc;

		case 2:
			PizzaShape ps = new PizzaShape(Color.orange);
			setPizza(ps, cell);
			return ps;

		}

		return null;

	}

	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	private void setFilledCircle(FilledCircle fc, Square cell) {
		int radius = cell.getWidth() / RADIUS_DIVISOR;
		fc.setRadius(radius);
		fc.setX(cell.getCenterX() - radius);
		fc.setY(cell.getCenterY() - radius);
	}

	/**
	 * sets a PizzaShape size to fit the center of a cell
	 */
	private void setPizza(PizzaShape ps, Square cell) {
		int radius = cell.getWidth() / RADIUS_DIVISOR;
		ps.setWidth(radius * 2);
		ps.setXTopLeft(cell.getCenterX() - radius);
		ps.setYTopLeft(cell.getCenterY() - radius);
	}

	/**
	 * sets a SquareWithCircles size to fit the center of a cell
	 */
	private void setSquareWithCircles(SquareWithCircles swc, Square cell) {
		int radius = cell.getWidth() / RADIUS_DIVISOR;
		swc.setWidth(radius * 2);
		swc.setXTopLeft(cell.getCenterX() - radius);
		swc.setYTopLeft(cell.getCenterY() - radius);
	}

	// determinants the 3 random shapes
	@Override
	public void play() {
		leftShape = createShape((int) (3 * Math.random()), leftCell);
		rightShape = createShape((int) (3 * Math.random()), midCell);
		midShape = createShape((int) (3 * Math.random()), rightCell);
		repaint();
	}

	@Override
	public Shape getShapeAtIndex(int index) {
		switch (index) {
		case 0: {
			return leftShape;
		}
		case 1: {
			return rightShape;
		}
		case 2: {
			return midShape;
		}
		}
		return null;
	}

}
