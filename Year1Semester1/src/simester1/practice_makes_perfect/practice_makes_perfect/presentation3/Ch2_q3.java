package simester1.practice_makes_perfect.practice_makes_perfect.presentation3;

import java.util.*;

public class Ch2_q3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final int DIGIT_NUM_FACTOR = 2;
		int num, DigitNumber=0, num1 = 0, num2 = 2;
		
		do {
			System.out.println("please entre a number");
			num = s.nextInt();
			DigitNumber = 0;
			for (int i=num ; i!=0 ; i/=10){
				DigitNumber++;
				if (DigitNumber==1) {
					num1 = i%10;
				}
				if (DigitNumber==2){
					num2 = i%10;
				}
			}
			System.out.printf("your number is %d \n", num);
		}while (!(DigitNumber==2 && num2==num1));
		System.out.print("thank you");
	}

}
