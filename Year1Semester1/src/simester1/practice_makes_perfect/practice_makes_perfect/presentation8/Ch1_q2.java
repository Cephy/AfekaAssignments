package simester1.practice_makes_perfect.practice_makes_perfect.presentation8;

import java.util.*;

public class Ch1_q2 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	
		final int AGE_MINER = 18, AGE_ADULTE = 65;
		int age;
		
		System.out.println("what is your age? ");
		age = s.nextInt();
		if (age>=AGE_ADULTE)
			System.out.println("you are an pensioner ");
		else if (age>=AGE_MINER)
			System.out.println("you are an adult ");
		else
			System.out.println("you are a miner ");
			

	}

}
