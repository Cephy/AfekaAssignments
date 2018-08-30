package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_q3 {

	public static void main(String[] args) {
		int [] threeJumbGroup = new int[10];
		final int jump = 3;
		int temp=0;
		
		for (int i=0 ; i<threeJumbGroup.length ; i++ ){
			threeJumbGroup[i] = temp;
			System.out.printf("Value number %d is  %d \n",i,temp);
			temp +=jump;
		}		
	}

}
