package simester2.practive.midTermExam_Practice;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestSimulation {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int rows = 0, columns = 0;
		boolean menu = false, rowIsNotOk = true, columnIsNotOk = false;
		final int MAX_NUM = 20, MIN_NUM = 0;
		do {
			menu = false;
			try {
				if (rowIsNotOk) {
					System.out.println("Please enter the number of rows you wish to have: ");
					rows = s.nextInt();
					rowIsNotOk = false;
					columnIsNotOk = true;
					if (rows <= MIN_NUM || rows > MAX_NUM) {
						System.out.println("Please enter a between 1 - 1000");
						rowIsNotOk = true;
						columnIsNotOk = false;
						menu = true;
					}
				}

				if (columnIsNotOk) {
					System.out.println("Please enter the number of columns you wish to have: ");
					columns = s.nextInt();
					columnIsNotOk = false;
					if (columns <= MIN_NUM || columns > MAX_NUM) {
						System.out.println("Please enter a between 1 - 1000");
						columnIsNotOk = true;
						menu = true;
					}
				}
			} catch (Exception IllegalArgumentException) {
				if (rowIsNotOk) {
					System.out.println("You have entered an invalid charchter ");
					s.next();
					menu = true;
				}
				if (columnIsNotOk) {
					System.out.println("You have entered an invalid charchter ");
					s.next();
					menu = true;
				}
			}

		} while (menu);

		JFrame frame = new JFrame("Sefi azoulay - 303139141");
		buildFrame(frame, rows, columns);
		setLabels(frame, rows, columns);
		s.close();
	}

	public static void buildFrame(JFrame frame, int rows, int columns) {
		frame.setSize((columns * 100), (rows * 100));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(new GridLayout(rows, columns));
	}

	public static void setLabels(JFrame frame, int rows, int columns) {
		for (int rowsC = 1; rowsC <= rows; rowsC++) {
			for (int coulmnsC = 1; coulmnsC <= columns; coulmnsC++) {
				JLabel temp = new JLabel("" + rowsC * coulmnsC, JLabel.CENTER);
				if ((rowsC % 2 == 1 && coulmnsC % 2 == 1) || (rowsC % 2 == 0 && coulmnsC % 2 == 0)) {
					
				} else {
					temp.setBackground(Color.YELLOW);
				}
				temp.setToolTipText("" + rowsC * coulmnsC);
				temp.setOpaque(true);
				frame.add(temp);
			}
		}
	}
}
