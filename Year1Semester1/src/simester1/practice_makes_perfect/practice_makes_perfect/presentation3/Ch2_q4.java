package simester1.practice_makes_perfect.practice_makes_perfect.presentation3;

import java.util.*;

public class Ch2_q4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final int FACTOR=3; 
		int num, DigitNum=0;
		
		do {
			DigitNum=0;
			System.out.printf("please enter a %d digit number that can be divided by 7\n", FACTOR);
			num = s.nextInt();
			for (int i=num ; i!=0 ; i/=10 ){
				DigitNum++;
				}
				
		} while (!(DigitNum==FACTOR && num%7==0));
		
		System.out.printf("your number is %d", num);
		
		
	}

}
