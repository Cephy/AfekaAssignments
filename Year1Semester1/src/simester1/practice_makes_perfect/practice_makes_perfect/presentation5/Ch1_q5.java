package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_q5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] numbers = new int[10];
		
		System.out.printf("please enter %d numbers \n",numbers.length);
		for (int i=0 ; i<numbers.length ; i++){
			numbers[i] = s.nextInt(); 
		if (i%2==0)
			numbers[i]--;
		if (i%3==0)
			numbers[i]--;
		}
		for (int i=0; i<numbers.length ; i++){
			if ((i%2==0) || (i%3==0)){
				if ((i%2==0) && (i%3==0)){
					System.out.printf("Your number was %d and it is now %d \n", numbers[i]+2, numbers[i]);
				}
				else{
					System.out.printf("Your number was %d and it is now %d \n", numbers[i]+1, numbers[i]);
				}
			}
			else	
				System.out.printf("your number is %d \n", numbers[i]);
		}
	}
}