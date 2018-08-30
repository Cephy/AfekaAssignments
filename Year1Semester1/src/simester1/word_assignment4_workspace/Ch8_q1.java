package simester1.word_assignment4_workspace;

import java.util.*;

public class Ch8_q1 {

	public static void main(String[] args){
		Scanner s = new Scanner (System.in);
		int size;
		
		System.out.println("Please enter the number of digits your number will contain");
		size = s.nextInt();
		
		int[] numbers = new int[size];
		System.out.printf("Please enter a %d digits number\n" ,size);
		for (int i=0 ; i<numbers.length ; i++){
			numbers[i] = s.nextInt();
		}	
		
		numbers = sort (numbers);
		
		for (int c: numbers){
			System.out.print(c);
		}
	}	
	public static int[] sort (int[] numbers){
		for (int i=numbers.length-1 ; i>0 ; i--){
			for (int j=0 ; j<i ; j++){
				if (numbers[j]<numbers[i]){
					swapNumbers(numbers, j);
				}
			}
		}
		return numbers;
	}
	public static void swapNumbers(int[] numbers, int location){
		int temp = numbers[location];
		numbers[location] = numbers[(location+1)];
		numbers[(location+1)]= temp;
	}
	
}