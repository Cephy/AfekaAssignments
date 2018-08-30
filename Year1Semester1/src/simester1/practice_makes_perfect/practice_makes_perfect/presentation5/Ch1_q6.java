package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_q6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char[] charcters = new char[10];
		int charcterComparison, counter=0;
		
		System.out.printf("please enter %d charcters \n", charcters.length);
		for(int i=0 ; i<charcters.length ; i++){
			charcters[i] = s.next().charAt(0);
		}
		System.out.println("please enter a charcter for comparison ");
			charcterComparison = s.next().charAt(0);
		for (int i=0 ; i<charcters.length ; i++){
			if (charcters[i]==charcterComparison){
				counter++;
			}
		}
		System.out.printf("your charcter #%c appearse %d times in the database",charcterComparison,counter);
	}
}
