package simester2.practive.worksheet5;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class DrawShapesPanel extends JPanel {

	private final int LINE = 1;
	private final int RECT = 2;
	private final int FILL_RECT = 3;
	private final int FILL_CIRC = 4;
	private int number;

	public DrawShapesPanel() {

	}

	public DrawShapesPanel(int number) {
		this.number = number;
	}

	public void setNumber(int number) {
		this.number = number;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.printComponents(g);
		switch (number) {
		case LINE: {
			g.drawLine(0, 0, getWidth() / 2, getHeight() / 2);
			break;
		}
		case RECT: {
			g.drawRect(0, 0, getWidth() / 2, getHeight() / 2);
			break;
		}
		case FILL_RECT: {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, getWidth() / 2, getHeight() / 2);
			break;
		}
		case FILL_CIRC: {
			g.setColor(Color.RED);
			g.fillOval(0, 0, getWidth() / 2, getHeight() / 2);
			break;
		}
		}
	}
}
