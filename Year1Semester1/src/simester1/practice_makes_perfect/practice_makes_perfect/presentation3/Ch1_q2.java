package simester1.practice_makes_perfect.practice_makes_perfect.presentation3;

import java.util.*;

public class Ch1_q2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		final int NUM_OF_ACTIVATIONS = 10;
		int num, i=0,j=0;
		
		System.out.println("Please entre a number ");
		num = s.nextInt();
		
		for (j=1; j<NUM_OF_ACTIVATIONS ; j++) {
			System.out.println("please enter a number ");
			num = s.nextInt();
			if ((num%2)==1) 
				i++;
		}
		System.out.println("you entered "+i+" odd numbers");
		
	}

}
