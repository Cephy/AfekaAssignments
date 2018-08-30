package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_q9 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int [] numbers = new int[5];
		
		System.out.printf("Please enter %d numbers \n", numbers.length);
		for (int i=0 ; i<numbers.length ; i++){
			numbers[i] = s.nextInt();
		}
		 
		for (int i=0 ; i<numbers.length ; i++){
			if(numbers[0]!=numbers[i]){
				System.out.print("the numbers you have typed are not equal ");
				break;
			}
			if (numbers.length-1==i){
				System.out.print("all of the numbers you have entered are equal");
			}
		}
	}
}
