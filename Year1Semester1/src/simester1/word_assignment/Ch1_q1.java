package simester1.word_assignment;

import java.util.*;

public class Ch1_q1 {

		public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
			double radius;
			final double PAI = 3.14159; 
			final int FACTOR = 2;		
			
			System.out.println("Please enter a radius of a circle? \n");
			radius = s.nextDouble();
			System.out.println("The circumference of the circle you entered is: \n" + (radius*FACTOR*PAI) + 
							   "\nThe surface of the circle is: \n" + (radius*radius*PAI));
		
		}

}
