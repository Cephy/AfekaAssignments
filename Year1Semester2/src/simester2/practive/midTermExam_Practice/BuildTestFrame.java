package simester2.practive.midTermExam_Practice;

import javax.swing.JFrame;

public class BuildTestFrame extends JFrame {

	private JFrame frame;
	private int rows;
	private int columns;

	public BuildTestFrame(JFrame frame, int rows, int columns) {
		this.frame = frame;
		this.rows = rows;
		this.columns = columns;
		frame.setSize(rows * 100, columns * 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

}
