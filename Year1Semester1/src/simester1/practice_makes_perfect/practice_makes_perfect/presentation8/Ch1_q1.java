package simester1.practice_makes_perfect.practice_makes_perfect.presentation8;

import java.util.*;

public class Ch1_q1 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	
		final int AGE_FACTOR = 18;
		int age;
		
		System.out.println("what is your age? ");
		age = s.nextInt();
		if (AGE_FACTOR>age)
			System.out.println("you are a miner");
		else
			System.out.println("you are an adult");

	}

}
