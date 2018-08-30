package simester1.word_assignment3_workspace1;

import java.util.*;

public class Ch6_q1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int number, newNumber;
		
		System.out.println("Please enter a number you wish to transform ");
		number = s.nextInt();

		newNumber = digitPlus1(number);
		
		System.out.printf("your new number is: %d", newNumber);
	}
	public static int digitPlus1(int number){
		int power=1;
		
		for (int i=number ; i!=0 ; i/=10 ){
			number+=(1*power);
			power*=10;
		}
		return number;			
	}
}
