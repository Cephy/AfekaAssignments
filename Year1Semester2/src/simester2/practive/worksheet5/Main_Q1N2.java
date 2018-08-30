package simester2.practive.worksheet5;

import java.util.*;

public class Main_Q1N2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int number = 0;

		DrawShapesFrame temp = new DrawShapesFrame();

		do {
			System.out.println("Enter 1 to draw the line...:\n" + "Enter 2 to draw the rect...:\n"
					+ "Enter 3 to draw fillRect...:\n" + "Enter 4 to draw fillOval...:\n"
					+ "Enter 0 to Exit the programme...:\n" + "Any other choice to draw the string...:\n"
					+ "Close the frame to end the program...\n");
			number = s.nextInt();
			temp.reset(number);

		} while (number != 0);

		s.close();
	}
}
