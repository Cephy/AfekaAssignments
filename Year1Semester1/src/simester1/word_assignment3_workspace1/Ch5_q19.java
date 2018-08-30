package simester1.word_assignment3_workspace1;

import java.util.*;

public class Ch5_q19 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);		
		int digits1, digits2;
		
		System.out.println("please enter the number of digits in your number and then the number "
						  + "itself one digit at a time");
		digits1 = s.nextInt();
		int[] num1 = new int[digits1];
		for (int i=0 ; i<num1.length ; i++){
			num1[i] = s.nextInt();
		}
		System.out.println("please enter the second number of digits in your second number "
						  + "and then the number itself one digit at a time");
		digits2 = s.nextInt();
		int[] num2 = new int[digits2];
		for (int i=0 ; i<num2.length ; i++){
			num2[i] = s.nextInt();
		}
		
		int[] result = multiplyNumbers(num1,num2);
		
		for (int i=0 ; i<result.length ; i++){
			System.out.print(result[i]);
		}
	}
	public static int[] multiplyNumbers (int[] num1, int[] num2){ 
		int digitStartLocation=0, digitLocation=0;
		int[] result = new int [(num1.length*num2.length)];
		
		for (int lowerNum=num2.length-1 ; lowerNum>=0 ; lowerNum-- ){
			digitLocation=0;
			for (int upperNum=num1.length-1 ; upperNum>=0 ; upperNum--){
				result[(result.length-1)-(digitStartLocation+digitLocation)] += (num1[upperNum]*num2[lowerNum])%10;
				result[(result.length-1)-(digitStartLocation+digitLocation+1)] += (num1[upperNum]*num2[lowerNum])/10;					
				if(result[(result.length-1)-(digitStartLocation+digitLocation)]>=10){
					result[(result.length-1)-(digitStartLocation+digitLocation+1)]++;
					result[(result.length-1)-(digitStartLocation+digitLocation)]%=10;
				}
				digitLocation++;
			}
			digitStartLocation++;
		}
		
		return result;
	}
}