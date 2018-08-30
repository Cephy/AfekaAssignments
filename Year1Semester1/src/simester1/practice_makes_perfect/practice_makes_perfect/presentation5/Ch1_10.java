package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] numbers = new int[5];
		
		System.out.printf("Please enter %d numbers \n", numbers.length);
		for (int i=0 ; i<numbers.length ; i++){
			numbers[i] = s.nextInt();
		}
		boolean checkSize = true;
		for (int i=numbers.length-1 ; i!=0; i--){
			if(numbers[i]<numbers[(i-1)]){
				System.out.print("the numbers are not organized by size \n");
				checkSize=false;
				break;
			}
		}
		if (checkSize==true){
			System.out.print("the numbers are orgenized by size");			
		}
	}	

}
