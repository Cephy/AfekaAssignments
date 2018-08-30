package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_q1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[10];
		
		System.out.printf("Please enter %d numbers \n",arr.length);
		for (int i=0 ; i<arr.length ; i++){
			arr[i] = s.nextInt();
		}
		System.out.printf("your numbers are: ");
		for (int i=0 ; i<arr.length ; i++){
			System.out.printf("%d " ,arr[i]);
		}
	}

}
