package simester1.word_assignment3_workspace1;

import java.util.Scanner;

public class Ch5_q13 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] numbers = new int [4];
		int maxValue=0;
		
		System.out.printf("please enter %d numbers \n",numbers.length);
		for(int i=0 ; i<numbers.length ; i++){
			numbers[i]=s.nextInt();
			if (numbers[i]>maxValue){
				maxValue=numbers[i];
			}
		}
		for(int rows=maxValue ; rows!=0 ; rows--){
			
			for(int columns=0 ; columns<numbers.length ; columns++){
				if (rows<=numbers[columns]){
					System.out.print("* ");
				}
				else{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("-------");
		for (int n: numbers){
			System.out.print(n + " ");
		}
	}
}
