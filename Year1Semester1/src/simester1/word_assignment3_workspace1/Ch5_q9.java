package simester1.word_assignment3_workspace1;

import java.util.*;

public class Ch5_q9 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] numbers = new int[6];
		boolean mirrorFlag = true;

		System.out.printf("please enter %d numbers \n",numbers.length);
		for (int i=0 ; i<numbers.length ; i++){
			numbers[i] = s.nextInt();
		}
		for (int i=0, j=numbers.length-1 ; i<j ; i++, j--){
			int swapedNumber=0; 
			for (int swap=numbers[i] ; swap!=0 ; swap/=10){
				swapedNumber*=10;
				swapedNumber+=swap%10;
			}
			if (swapedNumber!=numbers[j]){
				mirrorFlag = false;
				System.out.println("The array you have entered is not miror \n");
				break;
			}
		}		 
		if(mirrorFlag==true){
			System.out.println("The array you have entered is a miror \n");
		}
	}
}
