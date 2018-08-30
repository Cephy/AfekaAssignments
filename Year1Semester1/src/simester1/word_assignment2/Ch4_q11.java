package simester1.word_assignment2;

import java.util.*;

public class Ch4_q11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num, temp, counter=0;
		
		System.out.println("Please enter a number ");
		temp = num = s.nextInt();
		 
		for (int row=temp; row!=0 ;row--){
			for (int spaces=counter ; spaces!=0 ;spaces-- )
				System.out.print(" ");
			for (int lines=row ; lines!=0 ; lines--){
				System.out.print("* ");
			}
		System.out.println();
		counter++;
		}
	}

}
