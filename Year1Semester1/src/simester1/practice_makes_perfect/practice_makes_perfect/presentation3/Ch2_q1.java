package simester1.practice_makes_perfect.practice_makes_perfect.presentation3;

import java.util.*;

public class Ch2_q1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final int FACTOR = 5;
		int number, EvenNumFactor=0;
		
		
		do{
		   System.out.printf("please enter a number ");
		   number = s.nextInt();
		   if (number%2==0)
				EvenNumFactor+=1;
		   System.out.printf("your number is %d\n", number);
		} while	(EvenNumFactor < FACTOR);
		System.out.printf("your can only enter %d even numbers, thank you", FACTOR);
	}

}
