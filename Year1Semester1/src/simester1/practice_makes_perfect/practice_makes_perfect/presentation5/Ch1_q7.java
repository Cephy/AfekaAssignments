package simester1.practice_makes_perfect.practice_makes_perfect.presentation5;

import java.util.*;

public class Ch1_q7 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] numbers1 = new int[5], numbers2 = new int[5];
		
		System.out.printf("please enter %d numbers as a first comparison group \n" , numbers1.length);
		for (int i=0 ; i<numbers1.length ; i++){
			numbers1[i] = s.nextInt();
		}
		System.out.printf("please enter %d numbers as a second comparison group \n" , numbers2.length);
		for (int i=0 ; i<numbers1.length ; i++){
			numbers2[i] = s.nextInt();
		}
		int counter=0;
		for (int i=0 ; i<numbers1.length ; i++){
			if (numbers1[i]==numbers2[i]){
				System.out.printf("the number on the %d loction is equal on both groups \n", i);
				counter++;
			}
			if ((counter==0)&&(i+1==numbers1.length)){
				System.out.println("there are no equal numbers on both groupse on the same locations \n");
			}
		}
	}
}