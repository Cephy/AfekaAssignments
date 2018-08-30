package simester2.practive.worksheet3;

import java.util.*;

public class main_q3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int number = 0;
		boolean flag = false;

		do {
			try {
				System.out.println("Please enter a number: ");
				number = s.nextInt();
				flag = Numbers_q3.range(number);
			} catch (RangeException rangeException) {
				System.out.println("The number you have entered is not in range");
				flag = false;
			} catch (InputMismatchException InputMismatchException) {
				System.out.println("You need to enter a Integer ");
				flag = false;
				s.next();
			}

		} while (!flag);

		System.out.println("The number is in range");

		s.close();
	}
}
