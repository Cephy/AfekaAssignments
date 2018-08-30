package simester1.word_assignment2;

import java.util.*;

public class Ch4_q12 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num, counter=0;
		
		System.out.println("Please enter a number ");
		num = s.nextInt();
		 
		for (int row=num; row!=0 ;row--){
			for (int spaces=counter ; spaces!=0 ;spaces-- )
				System.out.print(" ");
			for (int lines=row ; lines!=0 ; lines--){
				System.out.print("* ");
			}
		System.out.println();
		counter++;
		}
		for (int row=0 ; row!=num ; row++){
			for (int spaces=1 ; spaces<counter ;spaces++ )
				System.out.print(" ");
			for (int lines=0 ; lines<=row ; lines++){
				System.out.print("* ");
			}
		System.out.println();
		counter--;
		}
	}

}