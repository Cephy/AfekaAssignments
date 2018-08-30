package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_q8 {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int[] numbers1 = new int[5], numbers2 = new int [5], sum = new int [5];
		
		System.out.printf("Please enter %d numbers for the first group \n", numbers1.length);
		for (int i=0 ; i<numbers1.length ; i++){
			numbers1[i] = s.nextInt();
		}
		System.out.printf("Please enter %d numbers for the second group \n", numbers1.length);
		for (int i=0 ; i<numbers1.length ; i++){
			numbers2[i] = s.nextInt();
		}
		for (int i=0 ; i<numbers1.length ; i++){
			sum[i] = numbers1[i]+numbers2[i];
			System.out.printf("The sum of the numbers on the number %d location is %d + %d = %d \n" 
							  ,i+1,numbers1[i],numbers2[i],sum[i]);
		}
	}

}