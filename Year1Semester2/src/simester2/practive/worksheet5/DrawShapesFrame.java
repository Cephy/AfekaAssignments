package simester2.practive.worksheet5;

import javax.swing.JFrame;

public class DrawShapesFrame extends JFrame {

	DrawShapesPanel tmp = new DrawShapesPanel();

	public DrawShapesFrame() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(true);
		add(tmp);
	}

	public DrawShapesFrame(int number) {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(true);
		tmp.setNumber(number);
		add(tmp);
	}

	public void reset(int number) {
		remove(tmp);
		tmp.setNumber(number);
		add(tmp);
	}

}
