package simester1.practice_makes_perfect.practice_makes_perfect.presentation3;

import java.util.*;

public class Ch1_q3 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
		
		int num, i = 1;
		
		System.out.println("please entre a number ");
		num = s.nextInt();
		System.out.println("all neumbers devided by 3: ");
		for (i=1; i<num ; i++) {
			if((i%3)==0) 
				System.out.println(i+" ");		
		}

	}

}
