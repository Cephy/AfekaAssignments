package simester2.practive.midTermExam_Practice;

import java.awt.Color;

import java.awt.GridLayout;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainFrame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int rows = 0, columns = 0;
		boolean menuFlag = false, rowNotOkFlag = true, columnNotOkFlag = false;
		do {
			menuFlag = false;
			try {
				if (rowNotOkFlag) {
					System.out.println("Please enter the number of rows?");
					rows = s.nextInt();
					columnNotOkFlag = true;
					rowNotOkFlag = false;
					if (rows < 0) {
						System.out.println("You can only enter a larger then 0 as the number of rows");
						columnNotOkFlag = false;
						rowNotOkFlag = true;
						menuFlag = true;
					}
				}
				if (columnNotOkFlag) {
					System.out.println("Please enter the number of columns?");
					columns = s.nextInt();
					menuFlag = false;
					if (columns < 0) {
						System.out.println("You can only enter a larger then 0 number of rows");
						menuFlag = true;
					}
				}

			} catch (Exception IllegalArgumentException) {
				menuFlag = true;
				if (rowNotOkFlag) {
					System.out.println("You have enterd an Illegal characterint the rows section");
					s.next();
				}
				if (columnNotOkFlag) {
					System.out.println("You have enterd an Illegal characterint the column section");
					s.next();
				}

			}
		} while (menuFlag);
		JFrame frame = new JFrame("Test");
		setFrame(frame, rows, columns);
		setLabels(frame, rows, columns);

		s.close();
	}

	public static void setFrame(JFrame frame, int width, int height) {
		frame.setSize((height * 100), (width * 100));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(width, height));
	}

	public static void setLabels(JFrame frame, int width, int height) {

		int jumpFlag = 0;
		int row = 0;
		for (int column = 0; column < height; column++) {
			jumpFlag++;
			for (; row < (width * jumpFlag); row++) {
				JLabel temp = new JLabel("" + row, JLabel.CENTER);
				temp.setToolTipText("" + row);
				temp.setBackground(new Color(getThreeDigitNum(), getThreeDigitNum(), getThreeDigitNum()));
				temp.setOpaque(true);
				frame.add(temp);
			}
		}
	}

	public static int getThreeDigitNum() {
		return (int) (Math.random() * 255);
	}

}
