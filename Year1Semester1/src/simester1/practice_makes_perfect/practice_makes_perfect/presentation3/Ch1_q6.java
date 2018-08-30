package simester1.practice_makes_perfect.practice_makes_perfect.presentation3;

import java.util.*;

public class Ch1_q6 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		final int Factor=5;
		int num, temp, sum=0, digit = 0;
		
		System.out.println("please enter a number ");
		num = s.nextInt();
		
		System.out.println("your numbers are: ");
		for (int i=num ; i!=0 ; i--){
			temp = num = i;
			for (int j=temp	; j!=0 ; j-- ){
				digit = temp%10;
				sum += digit;
				temp /=10;
			}
			if (num%3==0 && sum<Factor){
				System.out.print (num+" ");
			}
			sum = 0;
			
			
		}
	}

}
