package simester1.word_assignment3_workspace1;

import java.util.*;

public class Ch6_3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arrayLength, sumOf10;
		
		System.out.println("please enter the number of cells you wish your array will have");
		arrayLength = s.nextInt();
		
		int[] numbers = new int[arrayLength];
		System.out.println("Please enter numbers according to the number of cells you have chosen");
		for(int i=0 ; i<numbers.length ; i++){
			numbers[i] = s.nextInt();
		}
		sumOf10 = ifSum10(numbers);
		System.out.printf("the amount of times the sum of the digits of your numbers  was 10 is %d", sumOf10);
		
	}
	public static int ifSum10(int numbers[]){
		int counter=0;
		
		for(int i=0 ; i<numbers.length ; i++ ){
			if(sumOfDigits(numbers[i])==10){
				counter++;
			}
		}
		return counter;
	}
	public static int sumOfDigits(int number){
		int sumOfDigits=0;
		
		while(number!=0){
			sumOfDigits+=number%10;
			number/=10;
		}
		return sumOfDigits;
	}	
}	