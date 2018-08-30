package simester1.practice_makes_perfect.practice_makes_perfect.presentation3;

import java.util.*;

public class Ch1_q5 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
		
		int boom;
		
		System.out.println("please entre a number to play 7 Boom");
		boom = s.nextInt();
		
		for(int i=boom; i>0; i--){
			if ((i%7)==0) 
				System.out.println("BOOM!!!");
			else
				System.out.println(i+" ");
		}
	}

}
