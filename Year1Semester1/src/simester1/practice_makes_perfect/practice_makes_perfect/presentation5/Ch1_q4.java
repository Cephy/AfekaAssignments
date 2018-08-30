package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_q4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] numbers = new int[10];
		
		System.out.println("please enter a 10 numbers ");
		for (int i=0 ; i<numbers.length ; i++){	
			numbers[i] = s.nextInt();
			if (i%2==0){
				numbers[i]++;
			}		
		}	
		for (int i=0 ; i<numbers.length ; i++){
			if (i%2==0){
				System.out.printf("the number u typed in was %d and it is now %d \n", numbers[i]-1,numbers[i]);
			}
			else{
				System.out.printf("your number is %d \n",numbers[i]);
			}			
		}
	}

}
