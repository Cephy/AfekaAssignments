package simester1.word_assignment2;

import java.util.*;

public class Ch4_q15 {

	public static void main(String[] args) {
		
		final int INITIAL_VALUE=10, SQUENCE_BREAK_POINT = 3;
		int temp=0, digit=0,sum=0, counter, SequenceBreakCounter=0, NumberCounter=0;
		
		temp=counter=INITIAL_VALUE; 
		do{
			temp=counter;
			while (temp>9){
				sum=0;
				while (temp!=0){
					digit = temp%10; 
					sum += digit*digit;
					temp/=10;
				}
				temp = sum;
			}
			if (temp==1){
				NumberCounter++;
				SequenceBreakCounter++;
				System.out.printf("%d) %d is happy a number ;-)\n",NumberCounter ,counter);
			}
			else{
				SequenceBreakCounter=0;
			}
			counter++;
			} while(SequenceBreakCounter!=SQUENCE_BREAK_POINT);
		System.out.println(counter +" "+ (counter-1) +" "+ (counter-2));
	}
}
