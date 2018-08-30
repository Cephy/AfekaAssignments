package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_q2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char[] charecters = new char[10];
		int sizeChecker = 0;
			
		System.out.println("Please enter 10 Charecters");
		for (int i=0 ; i<charecters.length ; i++ ){
			charecters[i] = s.next().charAt(0);
		}
		
		for (int i=0 ; i<charecters.length ; i++){
			if(charecters[i]>charecters[sizeChecker]){
				sizeChecker=i;
			}
		}
		System.out.printf("the highest letter is %c and it's Index is %d ",charecters[sizeChecker],sizeChecker+1);
		
	}

}
 