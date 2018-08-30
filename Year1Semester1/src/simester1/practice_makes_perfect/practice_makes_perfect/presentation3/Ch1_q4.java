package simester1.practice_makes_perfect.practice_makes_perfect.presentation3;

import java.util.*;

public class Ch1_q4 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);

		int num;
	
		System.out.println("please enter a number ");
		num = s.nextInt();
		
		for(int i=num; i>0 ; i--)
			if ((i%3)==0)
				System.out.println(i + "");
	}

}
