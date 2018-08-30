package simester1.word_assignment2;

import java.util.*;

public class Ch4_q8 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final int DIGIT_BAR = 9;
		int num1, num2, digit=0, DigitQuantity=0, NewNumber=0, power=1, DigitCounter=0;
		
		
		System.out.println("Please enter 2 numbers with the same number of digits: ");
		num1 = s.nextInt();
		num2 = s.nextInt();
		
		System.out.println("your new number is: ");
		for (int i=num1 ; i!=0 ; i/=10, num2/=10){
			DigitQuantity=i%10;
			digit=num2%10;
			for (int j=0 ; j<DigitQuantity ; j++){
				NewNumber+=digit*power;
				power*=10;
				DigitCounter++;
				if (DigitCounter==DIGIT_BAR){
					break;
				}
			}
			if (DigitCounter==DIGIT_BAR){
				break;
			}
		}
		System.out.println(NewNumber);
		
	}		
}
